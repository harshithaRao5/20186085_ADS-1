public class Reserve {
	private int vacancies;
	private int unreserved;
	private int bc;
	private int sc;
	private int st;
	Reserve(int vac, int ur, int bc1, int sc1, int st1) {
		this.vacancies = vac;
		this.unreserved = ur;
		this.bc = bc1;
		this.sc = sc1;
		this.st = st1;
	}
	public void reservation() {
		Sort obj = new Sort();
			for (int i = 0; i <= unreserved; i++) {
				if (StudentDetails.getCategory().equals("open")) {
					obj.toString();
					break;
				}
			}
			for (int j = 0; j <= bc; j++) {
				if (StudentDetails.getCategory().equals("BC")) {
					obj.toString();
					break;
				}
			}
			for (int k = 0; k <= sc; k++) {
				if (StudentDetails.getCategory().equals("SC")) {
					obj.toString();
					break;
				}
			}
			for (int l = 0; l <= st; l++) {
				if (StudentDetails.getCategory().equals("ST")) {
					obj.toString();
					break;
				}
			}
		}
	}