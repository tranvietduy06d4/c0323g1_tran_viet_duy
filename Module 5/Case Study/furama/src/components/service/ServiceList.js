import { React, useState, useEffect } from "react";
import { getAll } from "../../services/FacilityService";

function ServiceList() {
  const [facilities, setFacilities] = useState([]);
  useEffect(() => {
    loadFacilitiesList();
  }, []);
  const loadFacilitiesList = async () => {
    const result = await getAll();
    setFacilities((prev) => result);
  };

  return (
    <>
      <div
        className="container-fluid d-flex justify-content-center row"
        style={{ marginTop: "5rem" }}
      >
        {facilities.map((facility) => (
          <div
            key={facility.id}
            className="card col-sm-6 col-md-4 col-lg-4 "
            style={{ width: "28rem", margin: "2rem" }}
          >
            <img
              src={facility.image}
              width={370}
              height={239}
              className="card-img-top"
              alt={facility.name}
            />
            <div className="card-body">
              <h5 className="card-title">{facility.name}</h5>
              <span className="card-text">
                Diện tích: {facility.area} m<sup>2</sup>
              </span>
              <span style={{ float: "right" }}>
                <a href="#" className="btn btn-outline-primary me-2">
                  Sửa
                </a>
                <a href="#" className="btn btn-outline-danger">
                  Xóa
                </a>
              </span>
            </div>
          </div>
        ))}
      </div>

      {/*modal-delete*/}
      <div
        className="modal fade"
        id="staticBackdrop1"
        data-bs-backdrop="static"
        data-bs-keyboard="false"
        tabIndex={-1}
        aria-labelledby="staticBackdropLabel"
        aria-hidden="true"
      >
        <div className="modal-dialog modal-dialog">
          <div className="modal-content">
            <form>
              <div
                className="modal-header"
                style={{ backgroundColor: "#FFD333" }}
              >
                <h5 className="modal-title fs-5" id="staticBackdropLabel">
                  Bạn chắc chắn muốn xóa
                </h5>
                <a type="button" data-bs-dismiss="modal">
                  <i
                    className="fa-regular fa-rectangle-xmark fa-2xl"
                    style={{ color: "#1f1e1e" }}
                  />
                </a>
              </div>
              <div className="modal-body">
                <input id="deleteServiceId" name="deleteId" type="hidden" />
                <span>Dịch vụ tên </span>
                <span id="serviceName" name="deleteName" />
              </div>
              <div className="modal-footer">
                <button type="submit" className="btn btn-danger">
                  Xóa
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}
export default ServiceList;
