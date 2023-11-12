package org.pritam.contactManager.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import org.pritam.contactManager.entity.Contact;
import org.pritam.contactManager.entity.CustomField;
import org.pritam.contactManager.entity.User;
import org.pritam.contactManager.model.LoggedInUser;
import org.pritam.contactManager.security.UserDetailsImpl;
import org.pritam.contactManager.service.ContactService;
import org.pritam.contactManager.service.CustomFieldService;
import org.pritam.contactManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/authenticated")
public class AuthenticatedGeneral {
		
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private CustomFieldService customFieldService;
	
	@Autowired
	private LoggedInUser loggedInUser;
	
	@Value("${contact.image.path}")
	private String contactImagePath;
	
	@ModelAttribute
	public void commonAttributes(Model model) {
		model.addAttribute("userFirstName", loggedInUser.getUser().getFirstName());
	}
	
	@GetMapping("/showContacts")
	public String showContacts() {
		return "showContacts";
	}
	
	@GetMapping("/createContact")
	public String createContact() {
		return "createContact";
	}
		
	@PostMapping("/saveContact")
	@ResponseBody
	public ResponseEntity<Object> saveContactImage(@RequestParam(name = "contactImage", required = false) MultipartFile file, 
			
			
			@RequestParam("jsonData") String jsonData) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		Map<String,String> map = mapper.readValue(jsonData, Map.class);

		//Saving contact data
		Contact contact = new Contact(map,loggedInUser.getUser().getUserid());
		contact = contactService.saveContact(contact);
		
		//Saving contact custom data if any
		int count=1;
		if(map.containsKey("customField"+count)) {
			LinkedList<CustomField> customFieldList = new LinkedList<CustomField>();
			while(map.containsKey("customField"+count)) {
			customFieldList.add(new CustomField(map.get("customField"+count),map.get("customFieldLabel"+count),contact.getContactid()));
			count+=1;
			}
			customFieldService.saveCustomFields(customFieldList);
		}
		
		//Saving contact image if any
		if(file!=null) {
			FileOutputStream fos = new FileOutputStream(contactImagePath
					+loggedInUser.getUser().getUserid()
					+"_"
					+contact.getContactid()
					+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')));
			fos.write(file.getBytes());
			fos.close();
		}
		return new ResponseEntity<Object>("OK",HttpStatus.CREATED);
	}
}
