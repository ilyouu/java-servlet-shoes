<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Giày - Shoes Shop</title>

<!-- Custom fonts for this template -->
<link href="./template/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link href="./template/css/font.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="./template/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="./template/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">



		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<form class="form-inline">
						<button id="sidebarToggleTop"
							class="btn btn-link d-md-none rounded-circle mr-3">
							<i class="fa fa-bars"></i>
						</button>
					</form>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Tìm kiếm..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Tìm kiếm..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<%
						String user = (String) session.getAttribute("user");
						%>

						<%
						if (user != null) {
						%>
						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small"> <% out.print("Hello " + user); %>
							</span> <img class="img-profile rounded-circle"
								src="./template/img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Đăng xuất
								</a>
							</div></li>
						<%
						}
						%>

						<%
						if (user == null) {
						%>
						<div class="">
							<a class="btn btn-primary btn-user" href="dang-nhap">Đăng
								nhập</a> <a class="btn btn-primary btn-user" href="dang-ky">Đăng
								ký</a>
						</div>

						<%
						}
						%>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<div class="row">
						<c:forEach var="giay" items="${giays}">
							<div class="col-lg-3 mb-4">
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h5 class="m-0 font-weight-bold text-primary">${giay.ten_giay}</h5>
									</div>
									<div class="card-body">
										<div class="text-center">
											<img class="img-fluid px-3 px-sm-4 mt-3 mb-4"
												style="width: 30rem;"
												src="./images/shoes/<c:out value="${giay.hinh_anh_1}"/>"
												alt="...">
										</div>
										<div
											class="d-flex flex-row align-items-center justify-content-between">
											<p class="text-success">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${giay.don_gia}" />
												VNĐ
											</p>
											<p class="text-danger">
												<del>
													<fmt:formatNumber type="number" maxFractionDigits="3"
														value="${giay.don_gia}" />
													VNĐ
												</del>
											</p>
										</div>


										<a href="shoe?id=<c:out value="${giay.id_giay}"/>">Xem chi
											tiết sản phẩm &rarr;</a>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Bản quyền &copy; PV Bang</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1"  role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Xác nhận đăng
						xuất</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Schọn "Đăng xuất" bên dưới nếu bạn đã
					sẵn sàng.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Không</button>
					<a class="btn btn-primary"
						href="<%session.invalidate();%>">Đăng xuất</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="./template/vendor/jquery/jquery.min.js"></script>
	<script src="./template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="./template/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="./template/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="./template/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="./template/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="./template/js/demo/datatables-demo.js"></script>

</body>

</html>