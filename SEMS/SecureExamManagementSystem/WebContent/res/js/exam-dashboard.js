
var eWarning =0;

$(window).load(function(){
	
	
})

$(document).ready(function(){
	startingUp()
	
	
	$(".nav-active a").click(function(){
// alert($(this).html())
		$("#temQue").html($(this).text())
	})
	
	
	
	$("#EndExam").click(function(){
		
		
		if(confirm("Are You Really Want Stop The Exam ?"))
			endExam("302");
	})
		
		
		
		window.onblur = function() {
//		console.log('lost focus');
		eWarning++;
		alert("Do not click outside of exam panel otherwise you will disqualified. Attempt Left:"+(4-eWarning));
		
			if(eWarning == 4)
			{
				endExam("303");
			}
	
	}	

	window.onfocus = function() {
		console.log('Got focus');
	}
	
})




function getCurrQuestion(pQId,pEID,pUID)
{
	let urlParams = new URLSearchParams();
    urlParams.append("FormType", "GetCurrQueDetail")
    urlParams.append("QID", pQId)
    urlParams.append("EID", pEID)
    urlParams.append("UID",pUID)
    fetch("/SecureExamManagementSystem/ExaminationController", {
        method: 'POST',
        body: urlParams
    }).then(function(response) {
        return response.text()
    }).then(
        function(text) {
        	$("#QuestionDiv").html(text);
    })
}


function submitAnswer(pQId,pEID,pUID){
	
	
	if($("input[name='option']:checked").val() != "undefined")
	{
		

	let urlParams = new URLSearchParams();
    urlParams.append("FormType", "SubmitAnswer")
    urlParams.append("QID", pQId)
    urlParams.append("EID", pEID)
    urlParams.append("UID",pUID)
    urlParams.append("SelectedOption",$("input[name='option']:checked").val())
    fetch("/SecureExamManagementSystem/ExaminationController", {
        method: 'POST',
        body: urlParams
    }).then(function(response) {
        return response.text()
    }).then(
        function(text) {
        	if(text==1){
        		
                new PNotify({
                    title: "Response",
                    text: "Question Submitted Successfully",
                    type: "success",

                });

        	}
        		//alert("Question Submitted Successfully")
        	else
        		{
        		
        		 new PNotify({
                     title: "Response",
                     text: "Quetion Submittion failed",
                     type: "success",
                    
                     stack: stack_bottomright
                 });

        		}
        		//alert("Quetion Submittion failed")	
    })
    }
    
    else{
    	alert("Please select option first");
	return false;
}
	
	
	
}


function getQuestion(pQId,pEID,pUID){
	
    let urlParams = new URLSearchParams();
    urlParams.append("FormType", "GetCurrQueDetail")
    urlParams.append("QID", pQId)
    urlParams.append("EID", pEID)
    urlParams.append("UID",pUID)
    fetch("/SecureExamManagementSystem/ExaminationController", {
        method: 'POST',
        body: urlParams
    }).then(function(response) {
        return response.text()
    }).then(
        function(text) {
        	debugger;
           console.log(json)
        })
	
}


function startingUp(){
	
	var sec = 10;
	setInterval(() => {
		$(".lds-dual-ring").html("<div class='startup-count' style='color:white'> Please wait... <br><br> staring exam in "+sec+" seconds</div>");
		if(sec == 0)
		{
				$(".lds-dual-ring").html("<div class='startup-count' style='color:white'>"+"STARING EXAM"+"</div>");
				$(".lds-dual-ring").remove();
				timeLimitInterval()
		}
		sec--;
	}, 1000);
}



function timeLimitInterval()
{
	var tlm = $("#tlm");
	var tls = $("#tls");
	
	
	var sec = tls.html();
	var examCountDown = setInterval(() => {
		
		
		if(Number( tlm.html()) != 0 )
		{
			if(Number( tls.html()) <= 0)
			{
				sec = 59;
				tlm.html(Number(tlm.html())-1);
			}
			
			tls.html(sec);
			sec -- 
		}else
		{
			if(Number( tls.html()) != 0)
			{
				if(Number( tls.html()) <= 0)
				{
					sec = 59;
					tlm.html(Number(tlm.html())-1);
				}
				
				tls.html(sec);
				sec -- 
			}else{
				clearInterval(examCountDown);
				alert("Time is out");
				endExam("301");
			}
			
		}
	}, 1000);
}



function endExam(pData)
{
	var eId = $("#exam").val();
	var uId = $("#user").val();
	
	window.location.href = "/SecureExamManagementSystem/exam?action=EE&&eid="+eId+"&&estatus="+pData;
	
}