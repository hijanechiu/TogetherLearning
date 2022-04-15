const dataObj = {
	account:"",
	answer1:"",
	answer2:"",
	answer3:"",
	answer4:"",
	account:"",
	categoryID:""

};


	
 
	Vue.createApp({
	data() {
		return dataObj;
	},
	mounted: function() {
	
	},
	methods: {
		calcaulate:function(){
			var selectedIndex1 = -1;
    var form1 = document.getElementById("formEN1");
    var i1 = 0;
    
    for (i1=0; i1<form1.r1.length; i1++)
    {
        if (form1.r1[i1].checked)
        {
            selectedIndex1 = i1;
            break;
        }
    }
   
    var selectedIndex2 = -1;
    var form2 = document.getElementById("formEN2");
    var i2 = 0;
    
    for (i2=0; i2<form2.r2.length; i2++)
    {
        if (form2.r2[i2].checked)
        {
            selectedIndex2 = i2;
            break;
        }
    }
    
    var selectedIndex3 = -1;
    var form3 = document.getElementById("formEN3");
    var i3 = 0;
    
    for (i3=0; i3<form3.r3.length; i3++)
    {
        if (form3.r3[i3].checked)
        {
            selectedIndex3 = i3;
            break;
        }
    }

    var selectedIndex4 = -1;
    var form4 = document.getElementById("formEN4");
    var i4 = 0;
    
    for (i4=0; i4<form4.r4.length; i4++)
    {
        if (form4.r4[i4].checked)
        {
            selectedIndex4 = i4;
            break;
        }
    }

   
      this.answer1=form1.r1[i1].value;
       this.answer2=form2.r2[i2].value;
       this.answer3=form3.r3[i3].value;
      this.answer4=form4.r4[i4].value;
       this.account="student1";
       this.sendBack();
   	},
		sendBack:function(){
			
		
		    axios({
			method: 'post',
			url: '/cnc/m2',
			headers: { "Access-Control-Allow-Origin": "*" },
			data:{ answer1:this.answer1,answer2:this.answer2,answer3:this.answer3,answer4:this.answer4,account:this.account,categoryID:this.categoryID}

			})

			.then(response => (console.log(response.data),alert("考試分數為:"+response.data),location.href="/TC"))
			.catch(function(error) {
				console.log(error);

			});
		}
	}
}).mount('#testCards')