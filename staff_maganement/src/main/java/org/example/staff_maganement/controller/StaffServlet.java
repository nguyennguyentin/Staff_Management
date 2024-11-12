package org.example.staff_maganement.controller;

import org.example.staff_maganement.model.Part;
import org.example.staff_maganement.model.Staff;
import org.example.staff_maganement.model.Title;
import org.example.staff_maganement.repository.PartRepository;
import org.example.staff_maganement.repository.StaffRepository;
import org.example.staff_maganement.repository.TitleRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "StaffServlet", urlPatterns = {""})
public class StaffServlet extends HttpServlet {
    private final StaffRepository staffRepository = new StaffRepository();
    private final PartRepository partRepository = new PartRepository();
    private final TitleRepository titleRepository = new TitleRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteStaff(request, response);
                break;

            default:
                listStaff(request, response);
                break;
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createStaff(request, response);
                break;
            case "edit":
                editStaff(request, response);
                break;
            case "search":
                searchStaff(request, response);
                break;
            case "list":
                listStaff(request, response);
                break;
            default:
                listStaff(request, response);
                break;
        }
    }

    private void listStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> staffList = staffRepository.findAll();
        // Đưa danh sách part và title để sử dụng trong dropdown trên JSP
        List<Part> partList = partRepository.findAll();
        List<Title> titleList = titleRepository.findAll();
        request.setAttribute("partList", partList);
        request.setAttribute("titleList", titleList);
        request.setAttribute("staffList", staffList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Part> partList = partRepository.findAll();
        List<Title> titleList = titleRepository.findAll();
        request.setAttribute("partList", partList);
        request.setAttribute("titleList", titleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void createStaff(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("nameStaff");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String cmnd = request.getParameter("cmnd");
        int partId = Integer.parseInt(request.getParameter("partId"));
        int titleId = Integer.parseInt(request.getParameter("titleId"));

        Part part = partRepository.findById(partId);
        Title title = titleRepository.findById(titleId);

        Staff staff = new Staff(0, name, birthday, cmnd, part, title);
        staffRepository.save(staff);

        response.sendRedirect("?action=");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)  {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffRepository.findById(id);
        List<Part> partList = partRepository.findAll();
        List<Title> titleList = titleRepository.findAll();

        request.setAttribute("staff", staff);
        request.setAttribute("partList", partList);
        request.setAttribute("titleList", titleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameStaff");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String cmnd = request.getParameter("cmnd");
        int partId = Integer.parseInt(request.getParameter("partId"));
        int titleId = Integer.parseInt(request.getParameter("titleId"));

        Part part = partRepository.findById(partId);
        Title title = titleRepository.findById(titleId);

        Staff staff = this.staffRepository.findById(id);
        staff.setNameStaff(name);
        staff.setBirthday(birthday);
        staff.setCmnd(cmnd);
        staffRepository.update(staff);
        RequestDispatcher dispatcher;
        request.setAttribute("staff",staff);
        dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffRepository.delete(id);
        response.sendRedirect("?action=");
    }



    private void searchStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameStaff");
        String titleIdParam = request.getParameter("titleId");
        String partIdParam = request.getParameter("partId");


        // Gọi phương thức tìm kiếm trong repository để lấy danh sách kết quả
        List<Staff> staffList ;
        if(name.isEmpty()) {
            staffList = staffRepository.search(titleIdParam, partIdParam);
        }else {
            staffList = staffRepository.search(name,titleIdParam, partIdParam);
        }

            // Đặt kết quả tìm kiếm vào request attribute để hiển thị trên JSP
        request.setAttribute("staffList", staffList);



        // Forward sang trang list.jsp
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

}
