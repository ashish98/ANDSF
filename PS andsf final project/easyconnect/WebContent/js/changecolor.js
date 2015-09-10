function navMouseOver(src){ 
	if (!src.contains(event.fromElement)){ 
		src.style.cursor = 'hand'; 
		src.bgColor = '#003F72'; 
	} 
} 
function navMouseOut(src){ 
	if (!src.contains(event.toElement)){ 
		src.style.cursor = 'default'; 
		src.bgColor = '#005197'; 
	} 
} 
