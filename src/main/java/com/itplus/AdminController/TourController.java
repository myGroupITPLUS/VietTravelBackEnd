package com.itplus.admincontroller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itplus.Model.TourDTO;
import com.itplus.Model.CategoryDTO;
import com.itplus.Model.PromotionDTO;
import com.itplus.Service.CategoryService;
import com.itplus.Service.PromotionService;
import com.itplus.Service.TourService;

@Controller
@RequestMapping(value = "/admin/tour")
public class TourController {
	
	@Autowired
	TourService tourService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	PromotionService promotionService;
	
	@RequestMapping(value = "/")
	public String getAllTour(HttpServletRequest request) {
		List<TourDTO> listTourDTO = tourService.getAllTour();
		request.setAttribute("listTour", listTourDTO);
		return "tour/listTour";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public  String addTour(HttpServletRequest request) {
		List<CategoryDTO> listCategoryDTO = categoryService.getAllCategory();
		List<PromotionDTO> lisPromotionDTO = promotionService.getAllPromotion();
		request.setAttribute("listCate", listCategoryDTO);
		request.setAttribute("listPro", lisPromotionDTO);
		request.setAttribute("tourDTO", new TourDTO());
		return "tour/addTour";
	}

	@RequestMapping(value = "/process-add", method = RequestMethod.POST)
	public  String doAddTour(HttpServletRequest request,@ModelAttribute("tourDTO") @Valid TourDTO tourDTO,BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile ) {
		if (bindingResult.hasErrors()) {
			return "add";
		}
		String imgFileName = imgFile.getOriginalFilename();
		if(!"".equals(imgFileName)){
			String path = request.getServletContext().getRealPath("/") + "resources/images/";
			System.out.println(path);
			File fileDir = new File(path);
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			try {
				imgFile.transferTo(new File(fileDir+File.separator+imgFileName));
				System.out.println("Upload file thành công!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		tourDTO.setImages(imgFileName);
		tourService.addTour(tourDTO);
		return "redirect:/admin/tour/add";
	}
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String getIdedit(HttpServletRequest request,@PathVariable(name = "id") int id) {
		TourDTO tourDTO = tourService.getTourById(id);
		List<CategoryDTO> listCategoryDTO = categoryService.getAllCategory();
		List<PromotionDTO> lisPromotionDTO = promotionService.getAllPromotion();
		CategoryDTO categoryDTO = categoryService.getCategoryById(tourDTO.getCategoryid());
		PromotionDTO promotionDTO = promotionService.getPromotionById(tourDTO.getPromotionid());
		request.setAttribute("tourDTO", tourDTO);
		request.setAttribute("listCate", listCategoryDTO);
		request.setAttribute("listPro", lisPromotionDTO);
		request.setAttribute("cate", categoryDTO);
		request.setAttribute("pro", promotionDTO);
		return "tour/editTour";
	}
	@RequestMapping(value = "/process-edit", method = RequestMethod.POST)
	public String editTour(HttpServletRequest request, @ModelAttribute("tourDTO") @Valid TourDTO tourDTO, BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		String imgFileName = imgFile.getOriginalFilename();
		if(!"".equals(imgFileName)){
			String path = request.getServletContext().getRealPath("/") + "resources/images/";
			System.out.println(path);
			File fileDir = new File(path);
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			try {
				imgFile.transferTo(new File(fileDir+File.separator+imgFileName));
				System.out.println("Upload file thành công!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		tourDTO.setImages(imgFileName);
		tourService.updateTour(tourDTO);
		return "redirect:/admin/tour/";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String getIddelete(HttpServletRequest request,@PathVariable(name = "id") int id) {
		tourService.deleteTour(id);
		return "redirect:/admin/tour/";
	}
}
