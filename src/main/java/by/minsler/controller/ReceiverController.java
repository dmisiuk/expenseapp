package by.minsler.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.helper.CreateReceiverCommand;
import by.minsler.helper.DeleteReceiverCommand;
import by.minsler.helper.EditReceiverCommand;
import by.minsler.helper.GetAllReceiverCommand;
import by.minsler.helper.ReceiverCommand;
import by.minsler.helper.SearchReceiverCommand;
import by.minsler.helper.UpdateReceiverCommand;

public class ReceiverController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String view = "/WEB-INF/view/receiver/";

		ReceiverCommand rcommand = null;
		if (request.getParameter("buttonShowAll") != null) {
			rcommand = new GetAllReceiverCommand();
			view += "showall.jsp";
		} else if (request.getParameter("buttonNew") != null) {
			view += "new.jsp";
		} else if (request.getParameter("buttonCreate") != null) {
			rcommand = new CreateReceiverCommand();
			view += "showall.jsp";
		} else if (request.getParameter("buttonSearch") != null) {
			view += "search.jsp";
		} else if (request.getParameter("buttonDelete") != null) {
			rcommand = new DeleteReceiverCommand();
			view += "showall.jsp";
		} else if (request.getParameter("buttonSearchByName") != null) {
			rcommand = new SearchReceiverCommand();
			view += "showall.jsp";
		} else if (request.getParameter("buttonEdit") != null) {
			rcommand = new EditReceiverCommand();
			view += "edit.jsp";
		} else if (request.getParameter("buttonUpdate") != null) {
			rcommand = new UpdateReceiverCommand();
			view += "showall.jsp";
		} else {
			view += "manage.jsp";
		}

		if (rcommand != null) {
			rcommand.execute(request);
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
