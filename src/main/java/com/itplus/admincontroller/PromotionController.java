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

import com.itplus.Model.PromotionDTO;
import com.itplus.Service.PromotionService;

@Controller
@RequestMapping(value = "/admin/promotion")
public class PromotionController {
	@Autowired
	PromotionService proService;
	@RequestMapping(value = "/")
	public String getAll(HttpServletRequest request) {
		List<PromotionDTO> promotionDTO = proService.getAllPromotion();
		request.setAttribute("listPromotion", promotionDTO);
		
		return "promotion/listPro";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public  String addPromotion(HttpServletRequest request) {
		request.setAttribute("promotionDTO", new PromotionDTO());
		return "promotion/addPromotion";
	}

	@RequestMapping(value = "/process-add", method = RequestMethod.POST)
	public  String doAdddPromotion(HttpServletRequest request,@ModelAttribute("promotionDTO") @Valid PromotionDTO promotionDTO,BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile ) {
		if (bindingResult.hasErrors()) {
			return "add";
		}
		String imgFileName = imgFile.getOriginalFilename();
		if(!"".equals(imgFileName)){
			String path = request.getServletContext().getRealPath("/") + "resources/images/";
			//System.out.println(path);
			File fileDir = new File(path);
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			try {
				imgFile.transferTo(new File(fileDir+File.separator+imgFileName));
				//System.out.println("Upload file thành công!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		promotionDTO.setImages(imgFileName);
		proService.addPromotion(promotionDTO);
		return "redirect:/admin/promotion/add";
	}
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String getIdedit(HttpServletRequest request,@PathVariable(name = "id") int id) {
		PromotionDTO promotionDTO = proService.getPromotionById(id);
		request.setAttribute("promotionDTO", promotionDTO);
		return "promotion/editPromotion";
	}
	@RequestMapping(value = "/process-edit", method = RequestMethod.POST)
	public String editPromotion(HttpServletRequest request, @ModelAttribute("promotionDTO") @Valid PromotionDTO promotionDTO, BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		String imgFileName = imgFile.getOriginalFilename();
		if(!"".equals(imgFileName)){
			String path = request.getServletContext().getRealPath("/") + "resources/images/";
			//System.out.println(path);
			File fileDir = new File(path);
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			try {
				imgFile.transferTo(new File(fileDir+File.separator+imgFileName));
				//System.out.println("Upload file thành công!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		promotionDTO.setImages(imgFileName);
		proService.updatePromotion(promotionDTO);
		return "redirect:/admin/promotion/";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String getIddelete(HttpServletRequest request,@PathVariable(name = "id") int id) {
		proService.deletePromotion(id);
		return "redirect:/admin/promotion/";
	}
}
