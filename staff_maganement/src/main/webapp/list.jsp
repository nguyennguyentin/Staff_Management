<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Staff List</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            padding: 20px;--%>
<%--        }--%>

<%--        form {--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--        }--%>

<%--        table, th, td {--%>
<%--            border: 1px solid black;--%>
<%--        }--%>

<%--        th, td {--%>
<%--            padding: 8px;--%>
<%--            text-align: left;--%>
<%--        }--%>
<%--        nav{--%>

<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<nav class="navbar navbar-expand-lg bg-body-tertiary">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">QUẢN LÝ NHÂN VIÊN</font></font></a>--%>
<%--        <a href="?action=create" class="btn btn-success mb-3">Thêm Nhân Viên Mới</a>--%>
<%--        <form action="?action=search" method="post">--%>
<%--            <div class="row">--%>
<%--                <div class="col mb-3">--%>
<%--                    <label for="nameStaff" class="form-label">Name:</label>--%>
<%--                    <input type="text" id="nameStaff" name="nameStaff" class="form-control"><br><br>--%>
<%--                </div>--%>

<%--                <div class="col mb-3">--%>
<%--                    <label for="partId" class="form-label">Department:</label>--%>
<%--                    <select class="form-select" id="partId" name="partId" required>--%>
<%--                        <c:forEach var="part" items="${partList}">--%>
<%--                            <option--%>
<%--                                    <c:if test="${part.idPart == param.partId}">selected</c:if>>--%>
<%--                                    ${part.namePart}--%>
<%--                            </option>--%>
<%--                        </c:forEach>--%>
<%--                    </select><br><br>--%>
<%--                </div>--%>

<%--                <div class="col mb-3">--%>
<%--                    <label for="titleId" class="form-label">Title:</label>--%>
<%--                    <select class="form-select" id="titleId" name="titleId" required>--%>
<%--                        <c:forEach var="title" items="${titleList}">--%>
<%--                            <option--%>
<%--                                    <c:if test="${title.idTitle == param.titleId}">selected</c:if>>--%>
<%--                                    ${title.nameTitle}--%>
<%--                            </option>--%>
<%--                        </c:forEach>--%>
<%--                    </select><br><br>--%>
<%--                </div>--%>
<%--                <div class="col mb-3">--%>
<%--                        <button type="submit" class="btn btn-success" value="Search" >Search</button>--%>
<%--                        <button type="reset" class="btn btn-primary" value="Reset" onclick="history.back() ">Reset</button>--%>
<%--                </div>--%>
<%--            </div>--%>


<%--        </form>--%>
<%--    </div>--%>
<%--</nav>--%>

<%--<div class="container">--%>
<%--    <h1 class="text-center text-primary">Danh sách Nhân Viên</h1>--%>

<%--<c:if test="${empty staffList}">--%>
<%--    <p>No staff found matching the criteria.</p>--%>
<%--</c:if>--%>


<%--<table border="1" class="table">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Name</th>--%>
<%--        <th>Birthday</th>--%>
<%--        <th>CMND</th>--%>
<%--        <th>Department</th>--%>
<%--        <th>Title</th>--%>
<%--        <th>Actions</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="staff" items="${staffList}">--%>
<%--        <tr>--%>
<%--            <td>${staff.nameStaff}</td>--%>
<%--            <td>${staff.birthday}</td>--%>
<%--            <td>${staff.cmnd}</td>--%>
<%--            <td>${staff.part.namePart}</td>--%>
<%--            <td>${staff.title.nameTitle}</td>--%>
<%--            <td>--%>
<%--                <a href="/?action=edit&id=${staff.idStaff}">Edit</a> |--%>
<%--                <a href="/?action=delete&id=${staff.idStaff}" onclick="return  confirm('Are you sure you want to delete this staff?');">Delete</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table></div>--%>
<%--</body>--%>
<%--</html>--%>






<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            padding: 20px;
        }

        .navbar {
            margin-bottom: 20px;
        }

        h1 {
            margin-bottom: 30px;
        }

        .table th, .table td {
            vertical-align: middle;
        }

        .table-striped tbody tr:nth-of-type(odd) {
            background-color: #f9f9f9;
        }

        .action-links {
            display: flex;
            gap: 10px;
        }

        .action-links a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Quản lý Nhân Viên</a>
        <a href="?action=create" class="btn btn-success">Thêm Nhân Viên Mới</a>
    </div>
</nav>

<div class="container">
    <h1 class="text-center text-primary">Danh sách Nhân Viên</h1>

    <form action="?action=search" method="post" class="mb-4">
        <div class="row">
            <div class="col-md-3 mb-3">
                <label for="nameStaff" class="form-label">Tên nhân viên:</label>
                <input type="text" id="nameStaff" name="nameStaff" class="form-control">
            </div>

            <div class="col-md-3 mb-3">
                <label for="partId" class="form-label">Phòng ban:</label>
                <select class="form-select" id="partId" name="partId" required>
                    <c:forEach var="part" items="${partList}">
                        <option <c:if test="${part.idPart == param.partId}">selected</c:if> value="${part.idPart}">
                                ${part.namePart}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-3 mb-3">
                <label for="titleId" class="form-label">Chức vụ:</label>
                <select class="form-select" id="titleId" name="titleId" required>
                    <c:forEach var="title" items="${titleList}">
                        <option <c:if test="${title.idTitle == param.titleId}">selected</c:if> value="${title.idTitle}">
                                ${title.nameTitle}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-3 mb-3 d-flex align-items-end">
                <button type="submit" class="btn btn-success w-100" >Tìm kiếm</button>
            </div>
        </div>
    </form>

    <c:if test="${empty staffList}">
        <div class="alert alert-warning" role="alert">
            Không có nhân viên nào phù hợp với tiêu chí tìm kiếm.
        </div>
    </c:if>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>CMND</th>
            <th>Phòng ban</th>
            <th>Chức vụ</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td>${staff.nameStaff}</td>
                <td>${staff.birthday}</td>
                <td>${staff.cmnd}</td>
                <td>${staff.part.namePart}</td>
                <td>${staff.title.nameTitle}</td>
                <td>
                    <a href="/?action=edit&id=${staff.idStaff}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="#" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#confirmDeleteModal" data-id="${staff.idStaff}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal Confirm Delete -->
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmDeleteModalLabel">Xác Nhận Xoá Nhân Viên</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn xoá nhân viên này không?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                <a id="confirmDeleteLink" href="#" class="btn btn-danger">Xoá</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script>
    // Khi người dùng click vào nút "Xoá", gán ID nhân viên vào nút xác nhận xoá trong Modal
    var deleteButtons = document.querySelectorAll('.btn-danger[data-bs-toggle="modal"]');
    deleteButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            var staffId = this.getAttribute('data-id');
            var confirmDeleteLink = document.getElementById('confirmDeleteLink');
            confirmDeleteLink.setAttribute('href', '/?action=delete&id=' + staffId);
        });
    });
</script>



