<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<!-- 設定頁面上所有文字的語言 -->

<head>
    <meta charset="utf-8"> <!-- 指定網頁所使用的編碼 -->
    <meta content="width=device-width, initial-scale=1.0" name="viewport"> <!-- 控制螢幕的寬度和縮放比例 -->
    
    <title>點數商城</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/TL2.png" rel="icon"> <!-- 網站標頭圖案-icon -->
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon"> <!-- 手機觸摸圖示 -->

    <!-- Google Fonts  谷歌字體-->
    <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

    <!-- Vendor CSS Files 供應商css文件-->
    <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File 模板主 CSS 文件-->
    <link href="assets/css/style27.css" rel="stylesheet">

    
    <!-- 購物車表格與css與js功能 -->
    <link rel="stylesheet" href="assets/css/buycarOrderProductList.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="assets/js/buycarproductlist.js"></script>
    

    <!-- =======================================================
* Template Name: Mentor - v4.7.0
* Template URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
======================================================== -->
</head>

<body>

    <!-- ======= Header 標頭/標題區塊 ======= -->
    <header id="header" class="fixed-top">
        <div class="container d-flex align-items-center">

            <img class=img src="assets/img/TL2.png">
            <h1 class="logo me-auto"><a href="/index">Together Learning</a></h1>
            <!-- Uncomment below if you prefer to use an image logo -->
            <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

            <nav id="navbar" class="navbar order-last order-lg-0">
                <ul>
                    <li><a href="/index">首頁</a></li> <!-- </a> 超連結 -->
                    <li><a href="/about">關於齊上</a></li>
                    <li class="dropdown"><a href="/subjects"><span>線上真人家教</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="/courses?subjectId=3">國文</a></li>
              <li><a href="/courses?subjectId=1">英文</a></li>
              <li><a href="/courses?subjectId=2">數學</a></li>
            </ul>
          </li>
                     <li><a href="/TC">測驗中心</a></li>
                      <li class="dropdown"><a href="#"><span>購買點數</span> <i class="bi bi-chevron-down"></i></a>
                    <ul>
                    <li><a href="/buycarOrderProduct">購買點數</a></li>
                    <li><a href="/buycarOrderquerymainaction">訂單明細</a></li>
                    </ul>
                    </li>
                     <li><a href="/contact">聯絡我們</a></li>
                    <li><a href="/student">會員專區</a></li>
                    <li><a href="/logout">登出</a></li>
                     <li><a href="購物車.html" class=""><i class="bi bi-cart"></i></a></li>
                    
                </ul>
                <i class="bi bi-list mobile-nav-toggle"></i>
            </nav><!-- .navbar -->
        </div>
    </header><!-- End Header -->
 <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs" data-aos="fade-in">
      <div class="container">
         <h2>點數商城</h2>
       <h4>歡迎來到點數商城,在這裡購買學習點數,開啟你的學習之旅!</h4>
      </div>
    </div><!-- End Breadcrumbs -->



    <!-- 購物車表格頁面 -->
    
    <div id="productListTitle">購買紀錄</div>
    
    <div id="showtable_div">
    <table id="showproduct" border="1">
    </table>
    <table id="showpage">
      <tr >
      <td>總頁數:${totalPages} 總筆數:${totalElements}</td>
      <td colspan="3" align="right" >Previous
         <c:forEach var="i" begin="1" end="${totalPages}" step="1">
             <button id="myPage" value="${i}" onclick="change(${i})">${i}</button>
         </c:forEach>Next
      </td>
       </tr>
     </table>
    </div>




    </main><!-- End #main -->

    <!-- ======= Footer ======= -->
    <footer id="footer">

        <div class="footer-top">
            <div class="container">
                <div class="row">

                    <div class="col-lg-3 col-md-6 footer-contact">
                        <h3>Together Learning</h3>
                        <strong>Phone:</strong> 07-9699885<br>
                        <strong>Email:</strong> info@example.com<br>
                        </p>
                    </div>

                    <div class="col-lg-2 col-md-6 footer-links">
                        <h4>Together Learning</h4>
                        <ul>
                            <li><i class="bx bx-chevron-right"></i> <a href="/index">首頁</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="/about">關於齊上</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="/contact">聯絡我們</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">服務條款隱私聲明</a></li>
                        </ul>
                    </div>

                    <div class="col-lg-3 col-md-6 footer-links">
                        <h4>學生回饋</h4>
                        <ul>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">學生心路歷程</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">老師課程評價</a></li>
                        </ul>
                    </div>

                    <div class="col-lg-4 col-md-6 footer-newsletter">
                        <h4>獲取最新資訊</h4>
                        <p>訂閱我們獲取最新資訊</p>
                        <form action="" method="post">
                            <input type="email" name="email"><input type="button" value="訂閱">
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <div class="container d-md-flex py-4">

            <div class="me-md-auto text-center text-md-start">
                <div class="copyright">
                    &copy; Copyright <strong><span>Mentor</span></strong>. All Rights Reserved
                </div>
                <div class="credits">
                    <!-- All the links in the footer should remain intact. -->
                    <!-- You can delete the links only if you purchased the pro version. -->
                    <!-- Licensing information: https://bootstrapmade.com/license/ -->
                    <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/ -->
                    Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                </div>
            </div>
            <div class="social-links text-center text-md-right pt-3 pt-md-0">
                <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
                <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
                <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
                <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
            </div>
        </div>
    </footer><!-- End Footer -->

    <div id="preloader"></div>
    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
            class="bi bi-arrow-up-short"></i></a>


    <!-- Vendor JS Files -->
    <script src="assets/vendor/purecounter/purecounter.js"></script>
    <script src="assets/vendor/aos/aos.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>


</body>

</html>