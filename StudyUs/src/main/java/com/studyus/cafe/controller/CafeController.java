package com.studyus.cafe.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.studyus.cafe.domain.Cafe;
import com.studyus.cafe.service.CafeService;

@Controller
public class CafeController {

	@Autowired
	private CafeService cService;

	// 스터디카페 리스트
	@RequestMapping(value = "cafeList.kh", method = RequestMethod.GET)
	public String cafeList(Model model) {
		ArrayList<Cafe> cList = cService.printAll();
		return null;
	}

	// 스터디카페 상세
	@RequestMapping(value = "cafeDetail.kh", method = RequestMethod.GET)
	public String cafeDetail(Model model) {
		return null;

	}

	// 스터디카페 등록
	@RequestMapping(value = "cafeWriteView.kh", method = RequestMethod.POST)
	public String registerCafe(@ModelAttribute Cafe cafe,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest request,
			Model model) {
		return null;

	}

	// 파일 저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\nuploadFiles";
		File folder = new File(savePath);
		return savePath;

	}

	// 스터디 카페 수정
	@RequestMapping(value = "cafeModifyView.kh", method = RequestMethod.GET)
	public String cafeModifyView(@RequestParam("caNo") int caNo, Model model) {
		return null;

	}

	// 스터디카페 삭제
	@RequestMapping(value = "cafeDelete.kh", method = RequestMethod.GET)
	public String cafeDelete(@RequestParam("caNo") int caNo, Model model, HttpServletRequest request) {
		return null;

	}
}