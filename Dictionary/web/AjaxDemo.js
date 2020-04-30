/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    console.log("Now you can perform Calculation");
});
function loaddata()
            {
                var DataString = "option=display";
                var Texter = DataString + "&text1="+$("#text1").val();
                //var DataString = request.getParameter("text1");
                $.ajax(
                        {
                            url:"AjaxDemo", data:Texter, type:"post",
                            success: function(data)
                            {
                                $("#dbdata").html(data);
                                //$("#text1").html($('input:textbox').val());
                            }
                        });
            }

