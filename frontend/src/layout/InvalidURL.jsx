import "./InvalidURL.css";

export default function NotFound() {
  return (
    <div className="container my-4">
      <div className="row">
        <div className="col-sm-12 ">
          <div className="col-sm-10 col-sm-offset-1  text-center">
            <div className="four_zero_four_bg">
              <h1 className="text-center lead fw-bold">404</h1>
            </div>

            <div className="contant_box_404">
              <h3 className="h2 lead fw-bold">Looks like you are lost</h3>

              <p className="lead fw-light">The page you are looking for is not available!</p>

              <a href="/" className="btn btn-dark btn-lg px-4 me-sm-3 text-nowrap">
                Go Home
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
