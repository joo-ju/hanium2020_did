<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>전자 헌혈증 관리 서비스</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
  <script type="text/javascript" src="<c:url value="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.js"/>"></script>

</head>

<body id="page-top">
  <!-- Page Wrapper -->
  <div id="wrapper">
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column" >
      <!-- Main Content -->
      <div id="content">
        <!-- Topbar -->
        <nav style="background-color: #718FE9; height: 100px;"class="navbar navbar-expand navbar-light  topbar static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Page Title -->
          <div>
            <h3 class="h3 mb-0 text-gray-200" style="margin-left: 2rem;">Blood donation certificate issuance service</h3>
          </div>
          <!-- End of Page title -->
          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Sign up, logout -->
            <div style="width:100%; margin:auto; ">
              <li class="mb-1" style="height: 30%; margin-left: 1rem;  margin-right:1rem; width: 80%;  text-align: center; ">
                <!-- <h4 class=" mb-0 text-gray-200" >  Donate</h4> -->
                <a href="http://localhost:8080/profile" class="d-none d-sm-inline-block  w-100  nav-link" style="padding: 0; background-color: #718FE9; color: white;"> <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-200"></i> Profile</a>
              </li>
              <li style="height: 20%; margin-left: 1rem;  width: 80%;    text-align: center; ">
                <!-- <h4 class=" mb-0 text-gray-200" >  Donate</h4> -->
                <a href="http://localhost:8080/login" class="d-none d-sm-inline-block  w-100 nav-link " style="padding: 0; background-color: #718FE9; color: white;"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-200"></i> Logout</a>
              </li>
            </div>

            <div class="topbar-divider d-none d-sm-block"></div>
          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Topbar2 -->
        <div class="navbar navbar-expand navbar-light topbar mb-4 shadow" style="background-color:#9FB4F3;">
          <div style="margin-right: 2rem; margin-left: 2rem; width: 150%;  text-align: center; float: left;">
            <h4 class=" mb-0 text-gray-200">  </h4>
          </div>
          <div style="height: 90%;margin-left: 2rem;  width: 150%;  text-align: center; float: left;">
             <a href="/my_blood_list" class="d-none d-sm-inline-block h-100 w-100 btn" style="color: white;"><h4> Enroll</h4></a>
          </div>
          <div style="height: 90%; margin-left: 2rem; width: 150%;  text-align: center; float: left;">
             <a href="/request_list" class="d-none d-sm-inline-block h-100 w-100 btn" style="color: white;"><h4> Donate</h4></a>
          </div>
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
          </div>
          <div style="margin-right: 2rem; margin-left: 2rem; width: 150%; text-align: center; float: left;">
            <h4 class=" mb-0 text-gray-200">  </h4>
          </div>
        </div>
        <!-- End of Topbar2 -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="card col-lg-7 o-hidden border-0 shadow-lg my-5" style="margin:auto">
            <div class="card-body p-0">
              <!-- Nested Row within Card Body -->
              <div class="row">
                <!-- <div class="col-lg-5 d-none d-lg-block bg-register-image"></div> -->
                <div class="col-lg-12">
                  <div class="p-5">
                  <c:set var="donate" value="${donateEnroll}" />
                    <div class="text-center">
                      <h1 class="h3 text-gray-900 mb-4">기부하기</h1>
                    </div>
                    <hr>
                    <!--카드 안 내용-->

                    <c:set var="donate" value="${donateEnroll}"/>
                    <c:set var="request" value="${requestEnl}" />
                    <form class="user" action="/donate_enroll/${request.reqId}" method="post" >
                      <p align="right">* 1개 이상 선택</p>
                      <!--고정값-->
                      <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">기관(개인)명</p>
                          <input disabled type="text" class="form-control form-control-user" placeholder="${request.user.group.gName}">
                        </div>
                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">필요증서수량</p>
                          <input disabled type="text" class="form-control form-control-user" placeholder="${request.reqAmount}">
                        </div>
                        <p class="col-sm-6" style="margin:1px;font-size: 1rem;">개수입력</p>
                        <input type="text" class="form-control form-control-user" name="donateAmount" id="donateAmount">
                        <p class="col-sm-6" style="margin:1px;font-size: 1rem;">reqId</p>
                                                <input type="text" class="form-control form-control-user" name="request.reqId" id="request.reqId">
                                                <p class="col-sm-6" style="margin:1px;font-size: 1rem;">userid</p>
                                                                        <input type="text" class="form-control form-control-user" name="user.userId" id="user.userId">
                      </div>
                      <!--헌혈증서 선택-->
                      <div class="form-group row">
                        <div class="col-sm-12 mb-3 mt-3 mb-sm-0">
                          <div class="table-responsive">
                            <p class="col-sm-6" style="margin:1px;font-size: 1rem;">헌혈 증서 선택 *</p>
                            <table class="table" id="datatable" width="100%" cellspacing="0">
                              <tr>
                                <th class="w-10"> </th>
                                <th class="w-10">헌혈 증서 번호</th>
                                <th class="w-10">혈액원명</th>
                                <th class="w-25">헌혈 용량</th>
                                <th class="w-25">혈액 종류</th>
                              </tr>
                              <c:forEach var="bloodDonation" items="${bdList}" varStatus="status" >   <!--list모든 내역 하나씩 불러오기-->
                              <tr>
                                <td>
                                  <input type="checkbox" id="donateAmount" name="donateAmount" value="${bloodDonation.bdId}">
                                  </td>
                                  <td>
                                  ${bloodDonation.bdId}
                                </td>
                                <td>
                                  ${bloodDonation.bloodInstitution.bdiName}
                                </td>
                                <td>
                                  ${bloodDonation.bdAmount}
                                </td>
                                <td>
                                  ${bloodDonation.bdType}
                                </td>
                              </tr>
                              </c:forEach>
                            </table>
                          </div>
                        </div>
                      </div>



                      </br>
                      <!--버튼-->
                      <div class="form-group row">
                        <div class="col-sm-2">
                          <a onclick="history.back()" class="btn   btn-user btn-block" style="background-color:red; color: white">   취소  </a>
                        </div>
                        <div>
                            <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                        </div>
                        <div class="col-sm-2">
                          <input type="submit" value="기부하기" id="donateBoard" class="btn   btn-user btn-block" style="background-color:#1cc88a; color: white;">
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->


      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->
  </div>
  <!-- End of Page Wrapper -->
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="http://localhost:8080/login">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="${pageContext.request.contextPath}/resources/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="${pageContext.request.contextPath}/resources/js/demo/chart-area-demo.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/demo/chart-pie-demo.js"></script>

</body>
<script type="text/javascript">
$(document).ready(function(){
    $("#getCheckedAll").click(function() {
    			$("input[name=donateAmount]:checked").each(function() {
    				var test = $(this).val();
    				console.log(test);
    			});
    		});
});
</script>
<script type="text/javascript">
$("#donateBoard").click(function(){
    confirm("기부하시겠습니까?");
});
</script>
</html>
<!--
	var result = confirm("기부하시겠습니까?");
	if(result){
	    donate.donateAmount=$("input:checkbox[donateAmount]:checked").length;
	}
-->