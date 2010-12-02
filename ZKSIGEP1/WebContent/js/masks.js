function applyZipCodeMask(compId){
	   applyMask(compId, "99.999-999")
	}
	 
	function applyPhoneMask(compId){
	   applyMask(compId, "(99) 9999-9999");
	}
	 
	function applyMask(compId, mask){
	   compId = '#' + compId;
	   jQuery(compId).mask(mask);
	}