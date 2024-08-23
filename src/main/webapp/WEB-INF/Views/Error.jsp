<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, 
                                initial-scale=1.0" />
<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "poppins";
}

.bg_img {
	background:
		url(
'https://media.geeksforgeeks.org/wp-content/uploads/20240226131034/2142357.jpg');
	height: 400px;
	width: 100%;
	background-repeat: no-repeat;
	background-position: center;
	background-size: contain;
}
</style>
<title>Document</title>
</head>

<body>
	<section class="py-5">
		<div class="d-flex justify-content-center  align-items-center flex-column  text-center w-100">
			<div class="bg_img w-50"></div>
			<div>
				<p class="display-4">Looks Like You're Lost</p>
				<p>The page you are looking for not available...</p>
				<a href="/SpringMVC" class="text-white text-decoration-none px-4 py-3 bg-success d-inline-block mt-2 rounded"> Go to Home </a>
			</div>
		</div>
	</section>
</body>

</html>
