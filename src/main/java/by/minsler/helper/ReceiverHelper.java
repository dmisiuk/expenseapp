package by.minsler.helper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.minsler.beans.Receiver;
import by.minsler.dao.ExpenseReceiverDAO;
import by.minsler.dao.MysqlExpenseReceiverDAO;

public class ReceiverHelper {

	private static Logger logger = Logger.getLogger(ReceiverHelper.class);

	public static int create(HttpServletRequest request) {
		int result;
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		String name = request.getParameter("name");
		if (name == null || name.trim().equals("")) {
			logger.info("receiver parameter not valid");
			request.setAttribute("flash", "receiver parameter not valid");
			logger.info("added flash to request");
			return 0;
		}
		Receiver receiver = new Receiver();
		receiver.setName(name);
		result = erdao.addReceiver(receiver);
		if (result == 1) {
			request.setAttribute("flash", "Success");
			logger.info("added flash to request");
		}
		logger.info("add receiver");
		return result;
	}

	public static int update(HttpServletRequest request) {
		int result;
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		if (name == null || name.trim().equals("")) {
			logger.info("receiver parameter not valid");
			request.setAttribute("flash", "receiver parameter not valid");
			logger.info("added flash to request");
			return 0;
		}
		Receiver receiver = new Receiver();
		receiver.setName(name);
		receiver.setNum(id);
		result = erdao.updateReceiver(receiver.getNum(), receiver);
		if (result == 1) {
			request.setAttribute("flash", "Success");
			logger.info("added flash to request");
		}
		logger.info("add receiver");
		return result;
	}

	public static void getAll(HttpServletRequest request) {
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		ArrayList<Receiver> list = erdao.getReceivers();
		logger.info("get all receiver");
		request.setAttribute("listreceiver", list);
		logger.info("added list receiver to request");
		return;
	}

	public static Receiver get(int id) {
		Receiver receiver = null;
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		receiver = erdao.getReceiver(id);
		logger.info("get receiver");
		return receiver;
	}

	// public static int deleteAll(HttpServletRequest request) {
	// int result;
	// ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
	// result = erdao.deleteAll();
	// request.setAttribute("flash", "table truncated");
	// logger.info("add flash message to request");
	// return result;
	// }

	public static int delete(HttpServletRequest request) {
		int result;
		int id = Integer.parseInt(request.getParameter("id"));
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		result = erdao.delReceiver(id);
		request.setAttribute("flash", "Deleted " + result + " receiver(s)");
		logger.info("add flash message to request");
		return result;
	}

	// public static void init(HttpServletRequest request) {
	// int count = 0;
	// logger.info("tryed init receiver table");
	// receiverDAOPostgres receiverdao = receiverDAOPostgres.getInstance();
	// ServletContext context = request.getSession().getServletContext();
	// String flash;
	// String homeDir = context.getRealPath("/");
	// String receiverDSLFile = context.getInitParameter("receiverDSLFile");
	// if (receiverDSLFile == null) {
	// flash = "set path to dsl receiver file in web.xml";
	// return;
	// }
	// File file = new File(homeDir, receiverDSLFile);
	// logger.info("create file: receiverDSLFile");
	// receiverParser parser = new receiverParser(file);
	// logger.info("create parser ");
	// while (parser.next()) {
	// if (receiverdao.addreceiver(parser.getreceiver())) {
	// logger.debug("added receiver "
	// + parser.getreceiver().getShortName());
	// count++;
	// }
	// }
	// parser.close();
	// logger.info("close parser ");
	// flash = "Added " + count + " receiver(s)";
	// request.setAttribute("flash", flash);
	// logger.info(flash);
	// return;
	// }

}
