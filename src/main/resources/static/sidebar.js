/* Set the width of the sidebar to 250px and the left margin of the page content to 250px */
function openNav() {
document.getElementById("mySidebar").style.width = "250px";
document.getElementById("page").style.marginLeft = "250px";
document.getElementById("footer").style.marginLeft = "250px";
}

/* Set the width of the sidebar to 0 and the left margin of the page content to 0 */
function closeNav() {
document.getElementById("mySidebar").style.width = "0";
document.getElementById("page").style.marginLeft = "0";
document.getElementById("footer").style.marginLeft = "0";

}

function toggleDropdown() {
const dropdownMenu = document.getElementById('dropdownMenu');
dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
}

// Close dropdown if clicked outside
window.onclick = function(event) {
if (!event.target.matches('.nav-link')) {
    const dropdowns = document.getElementsByClassName('dropdown-content');
    for (let i = 0; i < dropdowns.length; i++) {
        const openDropdown = dropdowns[i];
        if (openDropdown.style.display === 'block') {
            openDropdown.style.display = 'none';
        }
    }
}
}