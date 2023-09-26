import "./InvalidURL.css";

export default function NotFound() {
  return (
    <div class="container my-4">
      <div class="row">
        <div class="col-sm-12 ">
          <div class="col-sm-10 col-sm-offset-1  text-center">
            <div class="four_zero_four_bg">
              <h1 class="text-center lead fw-bold">404</h1>
            </div>

            <div class="contant_box_404">
              <h3 class="h2 lead fw-bold">Looks like you are lost</h3>

              <p className="lead fw-light">the page you are looking for is not available!</p>

              <a href="/" class="btn btn-dark btn-lg px-4 me-sm-3 text-nowrap">
                Go Home
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
