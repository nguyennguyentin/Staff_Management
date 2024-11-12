<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Add New Staff</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Add New Staff</h1>--%>
<%--<form action="?action=create" method="post">--%>
<%--    <label for="nameStaff">Name:</label>--%>
<%--    <input type="text" id="nameStaff" name="nameStaff" required><br><br>--%>

<%--    <label for="birthday">Birthday:</label>--%>
<%--    <input type="date" id="birthday" name="birthday" required><br><br>--%>

<%--    <label for="cmnd">CMND:</label>--%>
<%--    <input type="number" id="cmnd" name="cmnd" required><br><br>--%>

<%--    <label for="partId">Department:</label>--%>
<%--    <select id="partId" name="partId" required>--%>
<%--        <c:forEach var="part" items="${partList}">--%>
<%--            <option value="${part.idPart}">${part.namePart}</option>--%>
<%--        </c:forEach>--%>
<%--    </select><br><br>--%>

<%--    <label for="titleId">Title:</label>--%>
<%--    <select id="titleId" name="titleId" required>--%>
<%--        <c:forEach var="title" items="${titleList}">--%>
<%--            <option value="${title.idTitle}">${title.nameTitle}</option>--%>
<%--        </c:forEach>--%>
<%--    </select><br><br>--%>

<%--    <input type="submit" value="Add Staff">--%>
<%--</form>--%>
<%--<a href="?action=">Back to Staff List</a>--%>
<%--</body>--%>
<%--</html>--%>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Nhân Viên Mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            padding: 30px;
        }

        h1 {
            margin-bottom: 30px;
        }

        .form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        .form-label {
            font-weight: bold;
        }

        .btn-back {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="text-center text-primary">Thêm Nhân Viên Mới</h1>

    <div class="form-container">
        <form id="createForm" action="?action=create" method="post">
            <div class="mb-3">
                <label for="nameStaff" class="form-label">Tên Nhân Viên:</label>
                <input type="text" id="nameStaff" name="nameStaff" class="form-control" pattern="^[A-Za-zÀ-ÖØ-öø-ÿỲ-ỹẠ-ỹà-ỹ\s]+$" title="chuỗi không chứa số." required>
            </div>

            <div class="mb-3">
                <label for="birthday" class="form-label">Ngày Sinh:</label>
                <input type="date" id="birthday" name="birthday" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="cmnd" class="form-label">CMND:</label>
                <input type="text" id="cmnd" name="cmnd" class="form-control" pattern="^\d{9}$" title="Nhập chuỗi 9 chữ số." required>
            </div>

            <div class="mb-3">
                <label for="partId" class="form-label">Phòng Ban:</label>
                <select id="partId" name="partId" class="form-select" required>
                    <c:forEach var="part" items="${partList}">
                        <option value="${part.idPart}">${part.namePart}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="titleId" class="form-label">Chức Vụ:</label>
                <select id="titleId" name="titleId" class="form-select" required>
                    <c:forEach var="title" items="${titleList}">
                        <option value="${title.idTitle}">${title.nameTitle}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- Button to trigger the modal -->
            <button type="button" class="btn btn-success w-100" data-bs-toggle="modal" data-bs-target="#confirmModal">
                Thêm Nhân Viên
            </button>
        </form>

        <a href="?action=" class="btn btn-secondary btn-back w-100 mt-3">Quay lại danh sách nhân viên</a>
    </div>
</div>

<!-- Modal for confirmation -->
<div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmModalLabel">Xác nhận thêm</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn thêm nhân viên này không?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                <button type="button" class="btn btn-primary" onclick="document.getElementById('createForm').submit()">Xác nhận</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
