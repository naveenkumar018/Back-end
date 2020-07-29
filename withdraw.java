public withdrawATM(){
	def starttime=System.currenttimemilliss();
	
	systemapi api=new systemapi();
	Boolean done=false;
	float avg=0;
	
	api.scenarioLoad()
	api.domainsetup('open_account',customercount.tostring())
	api.generatorparameterset('open_account.branchcode',(branchcount-1).tostring())
	api.generatorparameterset('open_account.checking',[savings:'10000',current:'10000',fixed:'10000'])
	api.generatorparameterset('open_account.savings',[savings:'20000',current:'20000',fixed:'20000'])
	api.scenariorun()
	
	{
		while(!complete)
			try{
				api.scenarioLoad()
				api.generatorparameterset('user.amount',['100','200','500','2000'])
				api.domainsetloopcount('user',customercount.tostring())
				api.scenariorun()
			}
	}