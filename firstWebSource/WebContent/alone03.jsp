<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
 <script type="text/javascript" src="//code.jquery.com/jquery-1.9.1.js"></script>
      <script type="text/javascript" src="//code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
// window.onload = function (){
//   opener.popup = this;  //자식 창이 뜰때 opener에 popup이라는 변수에 this를 지정해주며, 부모창에서 'popup'으로 자식창의 함수를 호출함.
//   opener.document.getElementById('btn_play').disabled = false; 

// }
 
//  function call(str){
// //   opener.popup = null;
//   opener.document.getElementById('btn_play').disabled = true;
//   document.getElementById('div1').innerHTML +=  str +'<br />';
//  var qqqq=str;
//  document.write(qqqq);
//  }
	
</script>
</head>
<body>

	<%=request.getParameter("fileNum") %>
	
<div id = 'div1'></div>
<audio id="myaudio" autoplay="autoplay" controls="controls">

   <source id="main">
   <source src="files/<%=request.getParameter("fileNum") %>">
</audio>
<script>

</script>
<script>
$(function() {
   var index = 1;
   $('#play-next').click(function() {
      index++;
      if(index > $('#myaudio source').length) index=2;
      console.log( index + '번째 소스 재생' );

      $('#myaudio source#main').attr('src',
         $('#myaudio source:nth-child('+index+')').attr('src'));
      $("#myaudio")[0].load();
      $("#myaudio")[0].play();
   });
});

</script>
<button id='play-next'>next</button> 

<br />
<br />
</body>
</html>








