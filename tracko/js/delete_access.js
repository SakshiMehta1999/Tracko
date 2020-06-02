
function del(element){
  var office = element.id;
  alert(office);
  delbtn = new XMLHttpRequest();

  delbtn.open('get','DeleteBoss.do?del_office_id='+office,true);
	delbtn.onreadystatechange = deleteBosses;
	delbtn.send(null);
	

}

function deleteBosses(){
	if(delbtn.readyState==4&&delbtn.status==200)
		alert(delbtn.responseText);
	
}

$(document).ready(function(){
		$(".delete").click(function() {
        $(this).parent().parent().remove();
		});
	});
	///////////////////////////////////////////

function del2(element2){
  var office2 = element2.id;
  alert(office2);
  delbtn2 = new XMLHttpRequest();

  delbtn2.open('get','DeleteEmployee.do?del_office_id='+office2,true);
	delbtn2.onreadystatechange = deleteEmployees;
	delbtn2.send(null);
	

}

function deleteEmployees(){
	if(delbtn2.readyState==4&&delbtn2.status==200)
		alert(delbtn2.responseText);
	
}

$(document).ready(function(){
		$(".delete").click(function() {
        $(this).parent().parent().remove();
		});
	});


