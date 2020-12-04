<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Thêm Sách</title>
    </head>
    <body>
        <table>
            <c:url value="/process-addBook" var="url"></c:url>
			<form:form modelAttribute="bookDTO" method="post" action="${url }">
                <tr>
                    <th colspan="2" style="font-size: 30px;">Thêm mới sách</th>
                </tr>
                <tr>
                    <th colspan="2" style="font-size: 15px; color:green;">${message}</th>
                </tr>
                <tr>
                    <td>Mã sách</td>
                    <td><input type="text" name="bookCode"></td>
                </tr>
                <tr>
                    <td>Tiêu đề sách</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>Số trang</td>
                    <td><input type="text" name="numberOfPage" ></td>
                </tr>
                <tr>
                    <td>Tác giả</td>
                    <td><input type="text" name="author" ></td>
                </tr>
                <tr>
                    <td>Giá</td>
                    <td><input type="text" name="price" ></td>
                </tr>
                <tr>
                    <td>Ngày phát hành</td>
                    <td><input type="text" name="releaseDate" ></td>
                </tr>
                <tr>
                    <td>Loại sách</td>
                    <td>
	                    <select name="categoryID">
	                    	<c:forEach items="${listCategory}" var="cate">
	                    		<option value="${cate.categoryID}">${cate.categoryName}</option> 
            				</c:forEach> 	                                
	                    </select>
                    </td>
                </tr>                   
                <tr>
                    <td colspan="2"><input type="submit" value="Thêm" value="reset"><input type="reset" value="Reset"></td>
                </tr>
            </form:form>
        </table>
    </body>
</html>