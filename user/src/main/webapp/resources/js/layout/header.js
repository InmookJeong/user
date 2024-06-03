const logo = document.getElementById('logo');
logo.addEventListener('click', () => {
	location.href = "/";
});

const menuLink = document.getElementsByClassName('menu-link');
for (var i = 0; i < menuLink.length; i++) {
	menuLink[i].addEventListener('click', (event) => {
		const btnName = event.target.dataset.btnName;
		const btnTarget = event.target.dataset.btnTarget;
		const rootUrl = btnTarget === 'm' ? '/member' : '/';
		if(btnName) location.href = rootUrl + btnName;
	});
}