<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Giày - Shoes Shop</title>

    <!-- Custom fonts for this template -->
    <link href="./template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="./template/css/font.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./template/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="./template/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="./menu.jsp"></jsp:include>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <jsp:include page="./nav.jsp"></jsp:include>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">DANH SÁCH GIÀY</h6>
                            <a href="<%=request.getContextPath()%>/admin-shoes-add" class="btn btn-primary btn-user">Thêm</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Tên giày</th>
                                            <th>Loại giày</th>
                                            <th>Thương hiệu</th>
                                            <th>Đơn giá</th>
                                            <th>Thay đổi</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Tên giày</th>
                                            <th>Loại giày</th>
                                            <th>Thương hiệu</th>
                                            <th>Đơn giá</th>
                                            <th>Thay đổi</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <% int i=1; %>
					                    <c:forEach var="giay" items="${giays}">
						                    <tr>
						                        <th scope="row"><% out.println(i++); %></th>
						                        <td><c:out value='${giay.ten_giay}' /></td>
						                        <td><c:out value='${giay.ten_loai_giay}' /></td>
						                        <td><c:out value='${giay.ten_thuong_hieu}' /></td>
						                        <td>
						                        	<fmt:formatNumber type="number" maxFractionDigits="3" value="${giay.don_gia}" /> VNĐ
												</td>
						                        <td>
						                            <a href="admin-shoes-edit?id=<c:out value='${giay.id_giay}' />" type="button" class="btn btn-warning">Sửa</a>
						                            <a href="admin-shoes-delete?id=<c:out value='${giay.id_giay}' />" onclick="return confirm('Bạn có thật sự muốn xóa ?');" type="button"
						                                class="btn btn-danger">Xóa</a>
						                        </td>
						                    </tr>
					                    </c:forEach>
                                    </tbody>
                                </table>
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
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xác nhận đăng xuất</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Schọn "Đăng xuất" bên dưới nếu bạn đã sẵn sàng.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Không</button>
                    <a class="btn btn-primary" href="<%session.invalidate();%>trang-chu">Đăng xuất</a>
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