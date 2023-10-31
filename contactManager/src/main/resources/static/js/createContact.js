$(document).ready(function () {
   let customField = 0;
   const selectImage = document.querySelector('#select-image');
   const inputFile = document.querySelector('#file');
   const imgArea = document.querySelector('.img-area');

   selectImage.addEventListener('click', function () {
      inputFile.click();
   })

   inputFile.addEventListener('change', function () {
      const image = this.files[0]
      if (image.size < 20000000) {
         const reader = new FileReader();
         reader.onload = () => {
            const allImg = imgArea.querySelectorAll('img');
            allImg.forEach(item => item.remove());
            const imgUrl = reader.result;
            const img = document.createElement('img');
            img.src = imgUrl;
            imgArea.appendChild(img);
            imgArea.classList.add('active');
            imgArea.dataset.img = image.name;
         }
         reader.readAsDataURL(image);
      } else {
         alert("Image size more than 2MB");
      }
   })


   $("#addNewContactModal").show()

   $("#namePrefixDiv").hide()
   $("#firstNameDiv").show() 
   {
      $("#downIcon").show()
      $("#userIcon").show()
   }
   $("#middleNameDiv").hide()
   $("#surnameDiv").show()
   $("#nameSuffixDiv").hide()
   $("#phoneticSurnameDiv").hide()
   $("#phoneticMiddleNameDiv").hide()
   $("#phoneticFirstNameDiv").hide()
   $("#nicknameDiv").hide()
   $("#fileAsDiv").hide()

   $("#companyDiv").show()
   $("#departmentDiv").hide()
   $("#titleDiv").hide()

   $("#phoneDiv").show()
   $("#phoneLabelDiv").show()

   $("#emailDiv").show()
   $("#emailLabelDiv").show()

   $("#addressDiv").hide()
   $("#addressLabelDiv").hide()

   $("#websiteDiv").hide()

   $("#significantDateDiv").show()
   $("#significantDateLabelDiv").show()

   $("#relatedPersonDiv").hide()
   $("#relatedPersonLabelDiv").hide()

   $("#sipDiv").hide()

   $("#notesDiv").hide()

   $("#moreFieldsDiv").show()

   $("#customFieldDiv1").hide()
   $("#customFieldLabelDiv1").hide()
   $("#addCustomFieldDiv").hide()

   $(".customField").remove()
   $(".customFieldLabel").remove()

   $("#upIcon").on('click', function () {
      $("#namePrefixDiv").hide()
      $("#middleNameDiv").hide()
      $("#nameSuffixDiv").hide()
      $("#downIcon").show()
      $("#userIcon").show()
   });

   $("#downIcon").on('click', function () {
      $("#namePrefixDiv").show()
      $("#middleNameDiv").show()
      $("#nameSuffixDiv").show()
      $("#downIcon").hide()
      $("#userIcon").hide()
   });

   $("#phoneLabel").on('change', function () {
      if ($("#phoneLabel").val() === 'Custom') {
         $("#phoneLabel option").removeAttr('selected')
         $("#customPhoneLabelModal").show()
      }
   })

   $("#closeCustomPhoneLabelModal").on('click', function () {
      $("#phoneLabel").val("Mobile")
      $("#customPhoneLabelModal").hide()
   })

   $("#saveCustomPhoneLabelModal").on('click', function () {
      let customPhoneLabel = $("#customPhoneLabel").val()
      if (customPhoneLabel.trim().length > 0) {
         $("#phoneLabel option:last").after(`<option class="text-gray-500 font-bold" value="${customPhoneLabel}">${customPhoneLabel}</option>`)
         $("#phoneLabel").val(customPhoneLabel)
         $("#customPhoneLabelModal").hide()
      } else {
         $("#phoneLabel").val("Mobile")
         $("#customPhoneLabelModal").hide()
      }
   })


   $("#emailLabel").on('change', function () {
      if ($("#emailLabel").val() === 'Custom') {
         $("#emailLabel option").removeAttr('selected')
         $("#customEmailLabelModal").show()
      }
   })

   $("#closeCustomEmailLabelModal").on('click', function () {
      $("#emailLabel").val("Home")
      $("#customEmailLabelModal").hide()
   })

   $("#saveCustomEmailLabelModal").on('click', function () {
      let customEmailLabel = $("#customEmailLabel").val()
      if (customEmailLabel.trim().length > 0) {
         $("#emailLabel option:last").after(`<option class="text-gray-500 font-bold" value="${customEmailLabel}">${customEmailLabel}</option>`)
         $("#emailLabel").val(customEmailLabel)
         $("#customEmailLabelModal").hide()
      } else {
         $("#emailLabel").val("Home")
         $("#customEmailLabelModal").hide()
      }
   })


   $("#addressLabel").on('change', function () {
      if ($("#addressLabel").val() === 'Custom') {
         $("#addressLabel option").removeAttr('selected')
         $("#customAddressLabelModal").show()
      }
   })

   $("#closeCustomAddressLabelModal").on('click', function () {
      $("#addressLabel").val("Home")
      $("#customAddressLabelModal").hide()
   })

   $("#saveCustomAddressLabelModal").on('click', function () {
      let customAddressLabel = $("#customAddressLabel").val()
      if (customAddressLabel.trim().length > 0) {
         $("#addressLabel option:last").after(`<option class="text-gray-500 font-bold" value="${customAddressLabel}">${customAddressLabel}</option>`)
         $("#addressLabel").val(customAddressLabel)
         $("#customAddressLabelModal").hide()
      } else {
         $("#addressLabel").val("Home")
         $("#customAddressLabelModal").hide()
      }
   })

   $("#significantDateLabel").on('change', function () {
      if ($("#significantDateLabel").val() === 'Custom') {
         $("#significantDateLabel option").removeAttr('selected')
         $("#customSignificantDateLabelModal").show()
      }
   })

   $("#closeCustomSignificantDateLabelModal").on('click', function () {
      $("#significantDateLabel").val("Birthday")
      $("#customSignificantDateLabelModal").hide()
   })

   $("#saveCustomSignificantDateLabelModal").on('click', function () {
      let customSignificantDateLabel = $("#customSignificantDateLabel").val()
      if (customSignificantDateLabel.trim().length > 0) {
         $("#significantDateLabel option:last").after(`<option class="text-gray-500 font-bold" value="${customSignificantDateLabel}">${customSignificantDateLabel}</option>`)
         $("#significantDateLabel").val(customSignificantDateLabel)
         $("#customSignificantDateLabelModal").hide()
      } else {
         $("#significantDateLabel").val("Birthday")
         $("#customSignificantDateLabelModal").hide()
      }
   })


   $("#relatedPersonLabel").on('change', function () {
      if ($("#relatedPersonLabel").val() === 'Custom') {
         $("#relatedPersonLabel option").removeAttr('selected')
         $("#customRelatedPersonLabelModal").show()
      }
   })

   $("#closeCustomRelatedPersonLabelModal").on('click', function () {
      $("#relatedPersonLabel").val("Assistant")
      $("#customRelatedPersonLabelModal").hide()
   })

   $("#saveCustomRelatedPersonLabelModal").on('click', function () {
      let customRelatedPersonLabel = $("#customRelatedPersonLabel").val()
      if (customRelatedPersonLabel.trim().length > 0) {
         $("#relatedPersonLabel option:last").after(`<option class="text-gray-500 font-bold" value="${customRelatedPersonLabel}">${customRelatedPersonLabel}</option>`)
         $("#relatedPersonLabel").val(customRelatedPersonLabel)
         $("#customRelatedPersonLabelModal").hide()
      } else {
         $("#relatedPersonLabel").val("Assistant")
         $("#customRelatedPersonLabelModal").hide()
      }
   })

   $("#addMoreFields").on('click', function () {
      $("#phoneticSurnameDiv").show()
      $("#phoneticMiddleNameDiv").show()
      $("#phoneticFirstNameDiv").show()
      $("#nicknameDiv").show()
      $("#fileAsDiv").show()

      $("#departmentDiv").show()
      $("#titleDiv").show()

      $("#addressDiv").show()
      $("#addressLabelDiv").show()

      $("#websiteDiv").show()

      $("#relatedPersonDiv").show()
      $("#relatedPersonLabelDiv").show()

      $("#sipDiv").show()

      $("#notesDiv").show()

      $("#moreFieldsDiv").hide()

      $("#addCustomFieldDiv").show()
   });

   $("#addCustomField").on('click', function () {
      customField += 1
      if (customField === 1) {
         $("#customFieldDiv1").show()
         $("#customFieldLabelDiv1").show()
      } else {
         html = `
				<!--Custom Field ${customField}-->
				<div class="flex mt-3 justify-center customField" id="customFieldDiv${customField}">
				<div class="w-8">
				</div>
				<div class="w-4/5 px-2">
					<input type="text" id="customField${customField}" name="customField${customField}" class="block w-full rounded-2xl border-0 py-1.5 text-gray-500 font-bold text-sm shadow-sm ring-1 ring-inset ring-gray-300 placeholder:font-bold placeholder:text-gray-500 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="Custom Field">
				</div>
				<div class="w-8"></div>
				</div>
				
				<!--Custom Field Label ${customField}-->
				<div class="flex mt-3 justify-center customFieldLabel" id="customFieldLabelDiv${customField}">
				<div class="w-8">
				</div>
				<div class="w-4/5 px-2">
					<input type="text" id="customFieldLabel${customField}" name="customFieldLabel${customField}" class="block w-full rounded-2xl border-0 py-1.5 text-gray-500 font-bold text-sm shadow-sm ring-1 ring-inset ring-gray-300 placeholder:font-bold placeholder:text-gray-500 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="Custom Label">
				</div>
				<div class="w-8"></div>
				</div>`
         $("#customFields").append(html)
      }
   });
});