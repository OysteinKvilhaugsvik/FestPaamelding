function fornavnSjekk() {
		    const fornavn = document.forms["form"]["fornavn"];
		    const reg = /^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ_ ]{1,20}$/;
		    
		    if(reg.test(fornavn.value)){
		      	fornavn.style.border="2px solid green";
		  	} else {
		      fornavn.style.border="2px solid red";
		    }
		  	}
		    function etternavnSjekk(){
		      const etternavn = document.forms["form"]["etternavn"];
		      const reg = /^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ]{1,20}$/;
		      if(reg.test(etternavn.value)){
		        etternavn.style.border="2px solid green";
		      }else {
		        etternavn.style.border="2px solid red";
		      }
		    }
		    function mobilSjekk(){
		      const mobil = document.forms["form"]["mobil"];
		      const reg = /^[0-9]{8}$/;
		      if(reg.test(mobil.value)){
		    	  mobil.style.border="2px solid green";
		      }else {
		    	  mobil.style.border="2px solid red";
		      }
		  }
		    function passordSjekk(){
		      const passord = document.forms["form"]["passord"];
		      const reg = /^[a-zæøå]{1,8}$/;
		      const reg1 = /^[a-zæøåA-ZØÆÅ-]{4,8}$/;
		      const reg2 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
		      if(reg.test(passord.value)){
		    	  passord.style.border="2px solid red";
		      
		      }else if(reg1.test(passord.value)){
		    	  passord.style.border="2px solid orange";
		      }else if(reg2.test(passord.value)){
		    	  passord.style.border="2px solid green";
		      }
		    }
		    function passordRepetertSjekk(){
		      const passord = document.forms["form"]["passordRepetert"];
		      const passordRepetert = document.forms["form"]["passord"];
		      if(passord.value == passordRepetert.value){
		    	  passord.style.border="2px solid green";
		      }else {
		    	  passord.style.border="2px solid red";
		      }
		    }