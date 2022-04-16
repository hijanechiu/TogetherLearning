var indexPage = 1;

    $(document).ready(function(){
          loadPage(indexPage);
    });

    function loadPage(indexPage){
       $.ajax({
           type:'post',
           url:'/queryByPage/' + indexPage,
           dataType:'JSON',
           contentType:'application/json',
           success: function(data){
               console.log(data);
               
               $('#showproduct').empty("");
               
               if(data==null){
            	   $('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
               }else{
            	   var table = $('#showproduct'); 
            	   table.append("<tr id='ptitle'><th>交易代碼</th><th>1000點</th><th>5000點</th>><th>10000點</th><th>交易金額</th><th>交易日期</th></tr>");

            	   //data:jsonArray n:jsonObject
            	   $.each(data, function(i,n){
            		   var tr = "<tr align='center'>" + 
            		            "<td> "+ n.tradeNo + "</td>" +
            		            "<td>" + n.customField2 + "</td>" + 
            		            "<td>" + n.customField3 + "</td>" +
            		            "<td>" + n.customField4 + "</td>" +
            		            "<td>" + n.tradeAmt + "</td>" +
            		            "<td>" + n.tradeDate + "</td>" 
            		            "</tr>";
            		   table.append(tr);
                   });           	   
               }
           }
       });
    }

    function change(page){
    	indexPage = page;
    	loadPage(indexPage);
    } 