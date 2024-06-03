const logo = document.getElementById('logo');
logo.addEventListener('click', () => {
	location.href = "/";
});

const menuList = document.getElementsByClassName('menu');
for (let menu of menuList) {
	menu.addEventListener('click', (event) => {
		const menuName = event.target.dataset.menuName;
		const menuRole = event.target.dataset.menuRole;
		const rootUrl = menuRole === 'm' ? '/member' : '/';
		location.href = rootUrl + menuName;
	});
}