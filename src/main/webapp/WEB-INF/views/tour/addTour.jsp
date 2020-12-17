<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/header.jsp">
        <jsp:param name="title" value="Thêm tour" />
    </jsp:include>
<body class="hold-transition sidebar-mini layout-fixed">

    <%@include file="/WEB-INF/views/menubar.jsp" %>
    
    <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Thêm tour</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Thêm tour</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
			 <div class="card card-primary">
              <!-- form start -->
              <form:form modelAttribute="tourDTO" method="post" action="${pageContext.request.contextPath}/admin/tour/process-add" enctype="multipart/form-data">
                <div class="card-body">
              	  <div class="form-group">
	                  <label>Danh mục</label>
	                  <select class="form-control" name="categoryid">
	                    <option selected="selected" >Chọn danh mục</option>
	                    <c:forEach var="cate" items="${requestScope.listCate}">
		                    <option value="${cate.id}">${cate.categoryname}</option>
	                    </c:forEach>
	                  </select>
                  </div>
                  <div class="form-group">
	                  <label>Ưu đãi</label>
	                  <select class="form-control" name="promotionid">
	                    <option selected="selected">Chọn ưu đãi</option>
	                    <c:forEach var="pro" items="${requestScope.listPro}">
		                    <option value="${pro.id}">${pro.sale}</option>
	                    </c:forEach>
	                  </select>
                  </div>
                  <div class="form-group">
                    <label>Tên tour</label>
                    <input type="text" class="form-control" name="name" placeholder="Nhập tên tour">
                  </div>
                  <div class="form-group">
                    <label>Điểm đi</label>
                    <input type="text" class="form-control" name="diemdi" placeholder="Nhập điểm đi">
                  </div>
                  <div class="form-group">
                    <label>Điểm đến</label>
                    <input type="text" class="form-control" name="diemden" placeholder="Nhập điểm đến">
                  </div>
                  <div class="form-group">
                    <label>Thời gian đi</label>
                    <input type="text" class="form-control" name="timedi" placeholder="Nhập thời gian đi">
                  </div>
                  <div class="form-group">
                    <label>Thời gian về</label>
                    <input type="text" class="form-control" name="timeve" placeholder="Nhập thời gian về">
                  </div>
                  <div class="form-group">
                    <label>Mô tả</label>
                    <textarea class="form-control" rows="3" name="descriptions" placeholder="Nhập mô tả ..."></textarea>
                  </div>
                  <div class="form-group">
                    <label>Giá:</label>
                    <input type="text" class="form-control" name="price" placeholder="Nhập giá tiền">
                  </div>
                  <div class="form-group">
                    <label>Hình ảnh</label>
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" name="img">
                        <label class="custom-file-label" for="images">Chọn hình ảnh</label>
                      </div>
                    </div>
                  </div>
                  <input type="hidden" name="" id="images">
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Thêm mới</button>
                </div>
              </form:form>
            </div>
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/assets/plugins/jquery/jquery.min.js" />"></script>
<!-- Bootstrap 4 -->
<script src="<c:url value="/resources/assets/plugins/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<!-- bs-custom-file-input -->
<script src="<c:url value="/resources/assets/plugins/bs-custom-file-input/bs-custom-file-input.min.js" />"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/assets/dist/js/adminlte.min.js" />"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/resources/assets/dist/js/demo.js" />"></script>
<!-- Page specific script -->
<script>
$(function () {
	  bsCustomFileInput.init();
	});
$(document).ready(function(){ 
    $('input[type="file"]').change(function(e){ 
        var image = e.target.files[0].name; 
        $("#images").val(image); 
    }); 
}); 	
</script>
</body>
</html>