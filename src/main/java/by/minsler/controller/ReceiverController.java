package by.minsler.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.helper.ReceiverHelper;

public class ReceiverController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String view = "/WEB-INF/view/receiver/";

		if (request.getParameter("buttonShowAll") != null) {
			ReceiverHelper.getAll(request);
			view += "showall.jsp";
		} else if (request.getParameter("buttonNew") != null) {
			view += "new.jsp";
		} else if (request.getParameter("buttonCreate") != null) {
			ReceiverHelper.create(request);
			ReceiverHelper.getAll(request);
			view += "showall.jsp";
		} else if (request.getParameter("buttonSearch") != null) {
			view += "search.jsp";
		} else if (request.getParameter("buttonDelete") != null) {
			ReceiverHelper.delete(request);
			ReceiverHelper.getAll(request);
			view += "showall.jsp";
		} else if (request.getParameter("buttonSearchByName") != null) {
			ReceiverHelper.search(request);
			view += "showall.jsp";
		} else if (request.getParameter("buttonEdit") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("receiver", ReceiverHelper.get(id));
			view += "edit.jsp";
		} else if (request.getParameter("buttonUpdate") != null) {
			ReceiverHelper.update(request);
			ReceiverHelper.getAll(request);
			view += "showall.jsp";
		} else {
			view += "manage.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.include(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
