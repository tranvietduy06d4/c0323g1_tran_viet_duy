// Mở hộp thoại Đăng nhập
function openLoginModal() {
    document.getElementById("signupModal").style.display = "none";
    document.getElementById("loginModal").style.display = "block";
}

// Đóng hộp thoại Đăng nhập
function closeLoginModal() {
    document.getElementById("loginModal").style.display = "none";
}

// Mở hộp thoại Đăng ký
function openSignupModal() {
    document.getElementById("loginModal").style.display = "none"
    document.getElementById("signupModal").style.display = "block";
}

// Đóng hộp thoại Đăng ký
function closeSignupModal() {
    document.getElementById("signupModal").style.display = "none";
}