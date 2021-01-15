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

import com.itplus.Model.CategoryDTO;
import com.itplus.Service.CategoryService;

@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllCategory(HttpServletRequest request) {
		List<CategoryDTO> listCategoryDTO = categoryService.getAllCategory();
		request.setAttribute("listCategory", listCategoryDTO);
		return "category/listCate";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public  String addCategory(HttpServletRequest request) {
		request.setAttribute("categoryDTO", new CategoryDTO());
		return "category/addCategory";
	}

	@RequestMapping(value = "/process-add", method = RequestMethod.POST)
	public  String addCategory(HttpServletRequest request,@ModelAttribute("categoryDTO") @Valid CategoryDTO categoryDTO,BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile ) {
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
		categoryDTO.setImages(imgFileName);
		categoryService.addCategory(categoryDTO);
		return "redirect:/admin/category/add";
	}
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String getIdedit(HttpServletRequest request,@PathVariable(name = "id") int id) {
		CategoryDTO categoryDTO = categoryService.getCategoryById(id);
		request.setAttribute("categoryDTO", categoryDTO);
		return "category/editCategory";
	}
	@RequestMapping(value = "/process-edit", method = RequestMethod.POST)
	public String editCategory(HttpServletRequest request, @ModelAttribute("categoryDTO") @Valid CategoryDTO categoryDTO, BindingResult bindingResult,@RequestParam("img") MultipartFile imgFile) {
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
		categoryDTO.setImages(imgFileName);
		categoryService.updateCategory(categoryDTO);
		return "redirect:/admin/category/";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String getIddelete(HttpServletRequest request,@PathVariable(name = "id") int id) {
		categoryService.deleteCategory(id);
		return "redirect:/admin/category/";
	}
}
