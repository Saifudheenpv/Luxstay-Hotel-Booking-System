// Hotel Booking System - JavaScript

document.addEventListener('DOMContentLoaded', function() {
    // Initialize tooltips
    const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    const tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });

    // Initialize popovers
    const popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
    const popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
        return new bootstrap.Popover(popoverTriggerEl);
    });

    // Auto-dismiss alerts after 5 seconds
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(function(alert) {
        setTimeout(function() {
            const bsAlert = new bootstrap.Alert(alert);
            bsAlert.close();
        }, 5000);
    });

    // Form validation enhancement
    const forms = document.querySelectorAll('form');
    forms.forEach(function(form) {
        form.addEventListener('submit', function(e) {
            const submitBtn = form.querySelector('button[type="submit"]');
            if (submitBtn) {
                submitBtn.disabled = true;
                submitBtn.innerHTML = '<span class="loading"></span> Processing...';
            }
        });
    });

    // Date validation for booking forms
    const checkInInputs = document.querySelectorAll('input[name="checkInDate"]');
    const checkOutInputs = document.querySelectorAll('input[name="checkOutDate"]');
    
    checkInInputs.forEach(function(checkIn) {
        checkIn.addEventListener('change', function() {
            const checkOut = checkIn.closest('form').querySelector('input[name="checkOutDate"]');
            if (checkOut && checkIn.value) {
                checkOut.min = checkIn.value;
                if (checkOut.value && checkOut.value < checkIn.value) {
                    checkOut.value = '';
                }
            }
        });
    });

    checkOutInputs.forEach(function(checkOut) {
        checkOut.addEventListener('change', function() {
            const checkIn = checkOut.closest('form').querySelector('input[name="checkInDate"]');
            if (checkIn && checkOut.value && checkIn.value && checkOut.value <= checkIn.value) {
                alert('Check-out date must be after check-in date');
                checkOut.value = '';
            }
        });
    });

    // Search functionality enhancement
    const searchForms = document.querySelectorAll('form[action*="search"]');
    searchForms.forEach(function(form) {
        const searchInput = form.querySelector('input[name="query"]');
        if (searchInput) {
            searchInput.addEventListener('input', function() {
                if (this.value.length >= 3) {
                    // Could implement live search here
                    console.log('Search query:', this.value);
                }
            });
        }
    });

    // Price formatting
    function formatPrice(price) {
        return new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD'
        }).format(price);
    }

    // Room availability check
    function checkRoomAvailability(roomId, checkIn, checkOut) {
        // This would typically make an API call
        console.log(`Checking availability for room ${roomId} from ${checkIn} to ${checkOut}`);
        return Math.random() > 0.2; // Simulate availability
    }

    // Image lazy loading
    if ('IntersectionObserver' in window) {
        const imageObserver = new IntersectionObserver((entries, observer) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    const img = entry.target;
                    img.src = img.dataset.src;
                    img.classList.remove('lazy');
                    imageObserver.unobserve(img);
                }
            });
        });

        document.querySelectorAll('img[data-src]').forEach(img => {
            imageObserver.observe(img);
        });
    }

    // Smooth scrolling for anchor links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });

    // Add to favorites functionality
    const favoriteButtons = document.querySelectorAll('.favorite-btn');
    favoriteButtons.forEach(button => {
        button.addEventListener('click', function() {
            const hotelId = this.dataset.hotelId;
            const isFavorite = this.classList.contains('active');
            
            // Toggle visual state
            this.classList.toggle('active');
            const icon = this.querySelector('i');
            if (this.classList.contains('active')) {
                icon.classList.remove('far');
                icon.classList.add('fas', 'text-danger');
                showToast('Hotel added to favorites!');
            } else {
                icon.classList.remove('fas', 'text-danger');
                icon.classList.add('far');
                showToast('Hotel removed from favorites!');
            }
            
            // Here you would typically make an API call to update favorites
            console.log(`Hotel ${hotelId} ${isFavorite ? 'removed from' : 'added to'} favorites`);
        });
    });

    // Toast notification function
    function showToast(message, type = 'info') {
        // Create toast element
        const toast = document.createElement('div');
        toast.className = `toast align-items-center text-white bg-${type} border-0`;
        toast.setAttribute('role', 'alert');
        toast.innerHTML = `
            <div class="d-flex">
                <div class="toast-body">${message}</div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
            </div>
        `;
        
        // Add to toast container
        let toastContainer = document.querySelector('.toast-container');
        if (!toastContainer) {
            toastContainer = document.createElement('div');
            toastContainer.className = 'toast-container position-fixed bottom-0 end-0 p-3';
            document.body.appendChild(toastContainer);
        }
        toastContainer.appendChild(toast);
        
        // Show toast
        const bsToast = new bootstrap.Toast(toast);
        bsToast.show();
        
        // Remove from DOM after hide
        toast.addEventListener('hidden.bs.toast', function() {
            toast.remove();
        });
    }

    // Booking calendar functionality
    function initializeBookingCalendar() {
        const calendarEls = document.querySelectorAll('.booking-calendar');
        calendarEls.forEach(calendarEl => {
            // This would integrate with a calendar library like FullCalendar
            console.log('Initializing booking calendar');
        });
    }

    // Initialize when page loads
    initializeBookingCalendar();

    // Responsive navigation enhancement
    const navbarToggler = document.querySelector('.navbar-toggler');
    const navbarCollapse = document.querySelector('.navbar-collapse');
    
    if (navbarToggler && navbarCollapse) {
        navbarToggler.addEventListener('click', function() {
            navbarCollapse.classList.toggle('show');
        });
        
        // Close navbar when clicking outside on mobile
        document.addEventListener('click', function(e) {
            if (window.innerWidth < 992 && !navbarToggler.contains(e.target) && !navbarCollapse.contains(e.target)) {
                navbarCollapse.classList.remove('show');
            }
        });
    }

    // Performance monitoring
    let pageLoadTime = Date.now() - performance.timing.navigationStart;
    console.log(`Page loaded in ${pageLoadTime}ms`);

    // Error handling for images
    document.querySelectorAll('img').forEach(img => {
        img.addEventListener('error', function() {
            this.src = '/static/images/placeholder-hotel.jpg';
            this.alt = 'Image not available';
        });
    });
});

// Utility functions
const HotelBooking = {
    // Format date
    formatDate: function(dateString) {
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        return new Date(dateString).toLocaleDateString('en-US', options);
    },
    
    // Calculate days between dates
    calculateDays: function(checkIn, checkOut) {
        const oneDay = 24 * 60 * 60 * 1000;
        const firstDate = new Date(checkIn);
        const secondDate = new Date(checkOut);
        return Math.round(Math.abs((firstDate - secondDate) / oneDay));
    },
    
    // Validate email
    validateEmail: function(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    },
    
    // Debounce function for search
    debounce: function(func, wait) {
        let timeout;
        return function executedFunction(...args) {
            const later = () => {
                clearTimeout(timeout);
                func(...args);
            };
            clearTimeout(timeout);
            timeout = setTimeout(later, wait);
        };
    }
};

// Export for use in other modules
if (typeof module !== 'undefined' && module.exports) {
    module.exports = HotelBooking;
}
