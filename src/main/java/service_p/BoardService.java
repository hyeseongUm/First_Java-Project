package service_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface BoardService {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
