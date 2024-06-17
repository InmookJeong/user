if(window.location.pathname !== '/sign-up') {
	window.localStorage.removeItem("termsOfUse");
}

const logo = document.getElementById('logo');
const menuList = document.getElementsByClassName('menu');

logo.addEventListener('click', () => {
	location.href = "/";
});

for (let menuTag of menuList) {
	menuTag.addEventListener('click', (event) => {
		const menuName = event.target.dataset.menuName;
		const menuRole = event.target.dataset.menuRole;
		const rootUrl = menuRole === 'm' ? '/member' : '/';
		location.href = rootUrl + menuName;
	});
}

const selectMenu = (menu) => {
	for (let menuTag of menuList) {
		menuTag.classList.remove('selected');
		if(menuTag.dataset.menuName === menu) {
			menuTag.classList.add('selected');
		}
	}
}