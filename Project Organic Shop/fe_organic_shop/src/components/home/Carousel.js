const Carousel = () => {
  return (
    <>
      <div
        id="carouselExampleCaptions"
        className="carousel slide"
        data-bs-ride="carousel"
      >
        <div className="carousel-indicators">
          <button
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide-to={0}
            className="active"
            aria-current="true"
            aria-label="Slide 1"
          />
          <button
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide-to={1}
            aria-label="Slide 2"
          />
        </div>
        <div className="carousel-inner">
          <div className="carousel-item active">
            <img
              src={process.env.PUBLIC_URL + "/img/carousel-1.jpg"}
              className="d-block w-100"
              alt="Picture 1"
            />
            <div
              className="position-absolute fw-bold"
              style={{ left: "10rem", top: "30%", color: "orangered" }}
            >
              <h5 style={{ fontSize: "50px" }}>Sản phẩm hữu cơ</h5>
              <p style={{ fontSize: "60px" }}>Bảo vệ sức khỏe</p>
            </div>
          </div>
          <div className="carousel-item position-relative">
            <img
              src={process.env.PUBLIC_URL + "/img/carousel-2.jpg"}
              className="d-block w-100"
              alt="Picture 2"
            />
            <div
              className="position-absolute fw-bold"
              style={{ left: "10rem", top: "30%", color: "orangered" }}
            >
              <h5 style={{ fontSize: "50px" }}>Sản phẩm hữu cơ</h5>
              <p style={{ fontSize: "60px" }}>Bảo vệ hệ sinh thái</p>
            </div>
          </div>
        </div>
        <button
          className="carousel-control-prev"
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide="prev"
        >
          <span className="carousel-control-prev-icon" aria-hidden="true" />
          <span className="visually-hidden">Previous</span>
        </button>
        <button
          className="carousel-control-next"
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide="next"
        >
          <span className="carousel-control-next-icon" aria-hidden="true" />
          <span className="visually-hidden">Next</span>
        </button>
      </div>
    </>
  );
};
export default Carousel;
