function sendOrder(){
	
	
	var onek_unit = $("#onekunit").val();
    var fivek_unit = $("#fivekunit").val();
    var tenk_unit = $("#tenkunit").val();
    var TotalAmountppp = parseInt(onek_unit)*1000+parseInt(fivek_unit)*5000+parseInt(tenk_unit)*10000;
    


    $("#onekunit").val();
    $("#fivekunit").val();
    $("#tenkunit").val();
    $("#TotalAmount").val(TotalAmountppp);
    

   


}

