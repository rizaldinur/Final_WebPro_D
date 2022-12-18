<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Larissa Catering</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/styles.css ">
	</head>
	<body>
	
		<header>
			<nav class="navbar navbar-expand-md navbar-dark"
				style="background-color: tomato">
				<div>
					<a href="https://www.cateringlarissa.com" class="navbar-brand"> Larissa Catering </a>
				</div>
	
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/menulist"
						class="nav-link">Menus</a></li>
					<li><a href="<%=request.getContextPath()%>/reviewlist"
						class="nav-link">Reviews</a></li>
				</ul>
			</nav>
		</header>
		<br>
	
		<img src="catering.jpg" class= "catering" alt="catering">
		
		<section id="main">
        <div id="Carousel" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#Carousel" data-slide-to="0" class="active"></li>
            <li data-target="#Carousel" data-slide-to="1"></li>
            <li data-target="#Carousel" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner">
            <div class="carousel-item carousel-image-1 active">
              <div class="container">
                <div class="carousel-caption d-none d-sm-block mb-5">
                    <h1 class="display-3 h-color">Semua Jenis Masakan Ada Disini</h1>
                    <p class="lead">Catering Larissa melayani segala jenis pesanan, mulai dari tumpeng, nasi kotak, prasmanan, hingga cake dan roti.</p>
                    <a href="#" class="btn btn-color slide-btn btn-lg">Daftar Sekarang</a>
                </div>
              </div>
            </div>
    
            <div class="carousel-item carousel-image-2">
              <div class="container">
                <div class="carousel-caption d-none d-sm-block mb-5">
                    <h1 class="display-3 h-color">Berbagai Menu Tersedia</h1>
                    <p class="lead">Ingin melihat apa saja yang tersedia? Langsung jelajah produk-produk kami!</p>
                    <a href="#" class="btn btn-color slide-btn btn-lg">Lihat Menu</a>
                </div>
              </div>
            </div>
    
            <div class="carousel-item carousel-image-3">
              <div class="container">
                <div class="carousel-caption d-none d-sm-block  mb-5">
                    <h1 class="display-3 h-color">Masih Bingung?</h1>
                    <p class="lead">Silahkan akses panduan pemesanan di bawah ini.</p>
                    <a href="#" class="btn btn-color slide-btn btn-lg">Bantuan</a>
                </div>
              </div>
            </div>
        </div>
        
    
        <a href="#Carousel" data-slide="prev" class="carousel-control-prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
    
        <a href="#Carousel" data-slide="next" class="carousel-control-next">
            <span class="carousel-control-next-icon"></span>
        </a>
      </section>
	</body>
</html>