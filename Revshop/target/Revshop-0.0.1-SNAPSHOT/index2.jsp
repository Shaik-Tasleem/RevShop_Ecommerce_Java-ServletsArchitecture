<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Meta Tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevShop - Your Online Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        /* General Styles */
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f8f9fa;
            color: #333;
        }

        /* Navbar Styles */
        .navbar {
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .navbar-brand {
            font-size: 28px;
            font-weight: 700;
            color: #ff6b6b !important;
        }

        .navbar-nav .nav-link {
            color: #333 !important;
            font-weight: 500;
            margin-right: 15px;
            transition: color 0.3s;
        }

        .navbar-nav .nav-link:hover {
            color: #ff6b6b !important;
        }

        /* Hero Section */
        .hero-section {
            position: relative;
            height: 60vh;
            background-color: #f1f1f1;
        }

        .carousel-item img {
            height: 60vh;
            object-fit: cover;
        }

        .carousel-caption {
            bottom: 20%;
        }

        .carousel-caption h1 {
            font-size: 36px;
            font-weight: bold;
            text-shadow: 2px 2px 5px rgba(0,0,0,0.3);
        }

        .carousel-caption p {
            font-size: 18px;
        }

        /* Categories Section */
        .categories-section {
            padding: 50px 0;
            background-color: #fff;
        }

        .categories-section h2 {
            font-weight: 700;
            margin-bottom: 30px;
        }

        .category-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            overflow: hidden;
            background-color: white;
            transition: transform 0.3s;
            height: 100%;
        }

        .category-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .category-card h5 {
            padding: 15px;
            font-size: 20px;
            font-weight: 500;
        }

        .category-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        /* Footer */
        footer {
            background-color: #ffffff;
            color: #333;
            padding: 20px;
            text-align: center;
            border-top: 1px solid #ddd;
        }

        footer a {
            color: #ff6b6b;
            text-decoration: none;
        }

        footer a:hover {
            text-decoration: underline;
        }

        /* Media Queries */
        @media (max-width: 768px) {
            .carousel-caption h1 {
                font-size: 28px;
            }

            .carousel-caption p {
                font-size: 16px;
            }

            .category-card h5 {
                font-size: 18px;
            }
        }

        @media (max-width: 576px) {
            .hero-section {
                height: 50vh;
            }

            .carousel-item img {
                height: 50vh;
            }

            .carousel-caption h1 {
                font-size: 24px;
            }

            .carousel-caption p {
                font-size: 14px;
            }

            .category-card h5 {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
            <a class="navbar-brand" href="#">RevShop</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="registrationform.jsp">Sign Up</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section with Carousel -->
    <div id="heroCarousel" class="carousel slide hero-section" data-bs-ride="carousel" data-bs-interval="3000">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://images.pexels.com/photos/6214155/pexels-photo-6214155.jpeg?auto=compress&cs=tinysrgb&w=600" class="d-block w-100" alt="Hero Image 1">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Biggest Sale of the Year!</h1>
                    <p>Shop the best deals now!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=600" class="d-block w-100" alt="Hero Image 2">
                <div class="carousel-caption d-none d-md-block">
                    <h1>New Arrivals</h1>
                    <p>Explore the latest collections.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://images.pexels.com/photos/157675/fashion-men-s-individuality-black-and-white-157675.jpeg?auto=compress&cs=tinysrgb&w=600" class="d-block w-100" alt="Hero Image 3">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Trending Fashion</h1>
                    <p>Stay stylish with our new range.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://images.pexels.com/photos/6114613/pexels-photo-6114613.jpeg?auto=compress&cs=tinysrgb&w=600" class="d-block w-100" alt="Hero Image 4">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Latest Gadgets</h1>
                    <p>Discover the newest electronics!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://images.pexels.com/photos/788946/pexels-photo-788946.jpeg?auto=compress&cs=tinysrgb&w=600" class="d-block w-100" alt="Hero Image 5">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Top Toy Picks</h1>
                    <p>Fun and games for all ages.</p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#heroCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#heroCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <!-- Categories Section -->
    <div class="categories-section">
        <div class="container">
            <h2 class="text-center">Explore Our Categories</h2>
            <div class="row mt-4">
                <div class="col-md-4">
                    <div class="category-card">
                        <img src="https://images.pexels.com/photos/62689/pexels-photo-62689.jpeg?auto=compress&cs=tinysrgb&w=600" alt="Electronics">
                        <h5 class="text-center">Electronics</h5>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="category-card">
                        <img src="https://images.pexels.com/photos/1148957/pexels-photo-1148957.jpeg?auto=compress&cs=tinysrgb&w=600" alt="Fashion & Clothing">
                        <h5 class="text-center">Fashion & Clothing</h5>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="category-card">
                        <img src="https://images.pexels.com/photos/168866/pexels-photo-168866.jpeg?auto=compress&cs=tinysrgb&w=600" alt="Toys">
                        <h5 class="text-center">Toys & Games</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 RevShop | <a href="contact.jsp">Contact Us</a></p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
