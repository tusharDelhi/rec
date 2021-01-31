@SuppressWarnings("unchecked")
	public List<Object[]> showQueries(String discomName) {
		Session session1 = sf.openSession();
		String showData = "select d.userId,d.state,d.discomName,d.userName,d.queryNo,d.facility,d.queryDescription,queryRegistered,a.status,a.queryComplianceDate,a.remarks,a.adminId from discom d left join administrator a on d.admin_adminId=a.adminId where discomName=:discomName";	
		NativeQuery<Object[]> nq = session1.createNativeQuery(showData).setParameter("discomName", discomName);
		List<Object[]> queries = nq.list();
		log.info(queries);
		return queries;

	}