import React from 'react'
import PropTypes from 'prop-types'
import { CWidgetStatsD, CRow, CCol ,

  CTable,
  CTableBody,
  CTableDataCell,
  CTableHead,
  CTableHeaderCell,
  CTableRow,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'
import { cibFacebook, cibLinkedin, cibTwitter, cilCalendar } from '@coreui/icons'
import { CChart } from '@coreui/react-chartjs'

// 메인 대시보드의 소셜 뭐시기있는 통계 대시보드임

const WidgetsBrand = (props) => {
  const chartOptions = {
    elements: {
      line: {
        tension: 0.4,
      },
      point: {
        radius: 0,
        hitRadius: 10,
        hoverRadius: 4,
        hoverBorderWidth: 3,
      },
    },
    maintainAspectRatio: false,
    plugins: {
      legend: {
        display: false,
      },
    },
    scales: {
      x: {
        display: false,
      },
      y: {
        display: false,
      },
    },
  }

  return (
    <CRow className={props.className} xs={{ gutter: 4 }}>
  <CCol sm={6}>
    <div style={{ borderRadius: '15px', border: '1px solid #dee2e6', padding: '15px', backgroundColor: 'white'
     }}>
      <CTable className="text-center" style={{ backgroundColor: 'transparent' }}>
        <CTableHead>
          <CTableRow>            
            <CTableHeaderCell scope="col" colSpan={3}><h3>문의사항</h3></CTableHeaderCell>
          </CTableRow>
          <CTableRow>
            <CTableHeaderCell scope="col">닉네임</CTableHeaderCell>
            <CTableHeaderCell scope="col">제목</CTableHeaderCell>
            <CTableHeaderCell scope="col">작성시간</CTableHeaderCell>
          </CTableRow>
        </CTableHead>
        <CTableBody>
          <CTableRow>
            <CTableDataCell>Mark</CTableDataCell>
            <CTableDataCell>Mark</CTableDataCell>
            <CTableDataCell>Mark</CTableDataCell>
          </CTableRow>
          <CTableRow>
            <CTableDataCell>Jacob</CTableDataCell>
            <CTableDataCell>Jacob</CTableDataCell>
            <CTableDataCell>Jacob</CTableDataCell>
          </CTableRow>
          <CTableRow>
            <CTableDataCell>@twitter</CTableDataCell>
            <CTableDataCell>@twitter</CTableDataCell>
            <CTableDataCell>@twitter</CTableDataCell>
          </CTableRow>
        </CTableBody>
      </CTable>
    </div>
  </CCol>

  <CCol sm={6}>
  <div style={{ borderRadius: '15px', border: '1px solid #dee2e6', padding: '15px', backgroundColor: 'white'
     }}>
      <CTable className="text-center" style={{ backgroundColor: 'transparent' }}>
        <CTableHead>
          <CTableRow>            
            <CTableHeaderCell scope="col" colSpan={3}><h3>일일 접속자 수</h3></CTableHeaderCell>
          </CTableRow>
          <CTableRow>
            <CTableHeaderCell  scope="col">일자</CTableHeaderCell>
            <CTableHeaderCell  scope="col">방문자수</CTableHeaderCell>
          </CTableRow>
        </CTableHead>
        <CTableBody>
          <CTableRow>
            <CTableHeaderCell className="text-center" scope="row">2024.8.8. 13:12:00</CTableHeaderCell>
            <CTableDataCell className="text-center">11</CTableDataCell>
          </CTableRow>
          <CTableRow>
            <CTableHeaderCell className="text-center" scope="row">2</CTableHeaderCell>
            <CTableDataCell className="text-center">Jacob</CTableDataCell>
          </CTableRow>
          <CTableRow>
            <CTableHeaderCell className="text-center" scope="row">3</CTableHeaderCell>
            <CTableDataCell className="text-center">@twitter</CTableDataCell>
          </CTableRow>
        </CTableBody>
      </CTable>
    </div>
  </CCol>

  <CCol>
  <div style={{ borderRadius: '15px', border: '1px solid #dee2e6', padding: '15px', backgroundColor: 'white'
     }}>
      <CTable className="text-center" style={{ backgroundColor: 'transparent' }}>
        <CTableHead>
          <CTableRow>
            <CTableHeaderCell scope="col" colSpan={3}><h3>신고접수</h3></CTableHeaderCell>
          </CTableRow>
          <CTableRow>
            <CTableHeaderCell scope="col">닉네임</CTableHeaderCell>
            <CTableHeaderCell scope="col">제목</CTableHeaderCell>
            <CTableHeaderCell scope="col">작성시간</CTableHeaderCell>
          </CTableRow>
        </CTableHead>
        <CTableBody>
          <CTableRow>
            <CTableDataCell>Mark</CTableDataCell>
            <CTableDataCell>Mark</CTableDataCell>
            <CTableDataCell>Mark</CTableDataCell>
          </CTableRow>
          <CTableRow>
            <CTableDataCell>Jacob</CTableDataCell>
            <CTableDataCell>Jacob</CTableDataCell>
            <CTableDataCell>Jacob</CTableDataCell>
          </CTableRow>
          <CTableRow>
            <CTableDataCell>@twitter</CTableDataCell>
            <CTableDataCell>@twitter</CTableDataCell>
            <CTableDataCell>@twitter</CTableDataCell>
          </CTableRow>
        </CTableBody>
      </CTable>
    </div>
  </CCol>

  <CCol sm={6}></CCol>
</CRow>

//     <CRow className={props.className} xs={{ gutter: 4 }}>
//    <CCol sm={6} >
//       <CTable className="text-center">
//         <CTableHead>
//         <CTableRow>            
//       <CTableHeaderCell scope="col" colSpan={3}><h3>문의사항</h3></CTableHeaderCell>
//     </CTableRow>
//           <CTableRow>
//             <CTableHeaderCell scope="col">닉네임</CTableHeaderCell>
//             <CTableHeaderCell scope="col">제목</CTableHeaderCell>
//             <CTableHeaderCell scope="col">작성시간</CTableHeaderCell>

//           </CTableRow>
//         </CTableHead>
//         <CTableBody>
//           <CTableRow>
//             <CTableDataCell>Mark</CTableDataCell>
//             <CTableDataCell>Mark</CTableDataCell>
//             <CTableDataCell>Mark</CTableDataCell>
//           </CTableRow>
//           <CTableRow>
//             <CTableDataCell>Jacob</CTableDataCell>
//             <CTableDataCell>Jacob</CTableDataCell>
//             <CTableDataCell>Jacob</CTableDataCell>
//           </CTableRow>
//           <CTableRow>
//             <CTableDataCell>@twitter</CTableDataCell>
//             <CTableDataCell>@twitter</CTableDataCell>
//               <CTableDataCell>@twitter</CTableDataCell>
//           </CTableRow>
//       </CTableBody>
//     </CTable>
//       </CCol>
//       <CCol sm={6} >
//       <CTable className="text-center">
//   <CTableHead>
//     <CTableRow>            
//       <CTableHeaderCell scope="col" colSpan={3}><h3>일일 접속자 수</h3></CTableHeaderCell>
//     </CTableRow>
//     <CTableRow>
//       <CTableHeaderCell className="text-center" scope="col" sm={4}>일자</CTableHeaderCell>
//       <CTableHeaderCell className="text-center" scope="col" sm={2}>방문자수</CTableHeaderCell>
//     </CTableRow>
//   </CTableHead>
//   <CTableBody>
//     <CTableRow>
//       <CTableHeaderCell className="text-center" scope="row">2024.8.8. 13:12:00</CTableHeaderCell>
//       <CTableDataCell className="text-center" >11</CTableDataCell>
//     </CTableRow>
//     <CTableRow>
//       <CTableHeaderCell className="text-center" scope="row">2</CTableHeaderCell>
//       <CTableDataCell className="text-center">Jacob</CTableDataCell>
//     </CTableRow>
//     <CTableRow>
//       <CTableHeaderCell className="text-center" scope="row">3</CTableHeaderCell>
//       <CTableDataCell className="text-center" >@twitter</CTableDataCell>
//     </CTableRow>
//   </CTableBody>
// </CTable>
//   </CCol>
//   <CCol>
//       <CTable className="text-center">
//         <CTableHead>
//         <CTableRow>
//             <CTableHeaderCell scope="col" colSpan={3}><h3>신고접수</h3></CTableHeaderCell>
//           </CTableRow>
//           <CTableRow>
//             <CTableHeaderCell scope="col">닉네임</CTableHeaderCell>
//             <CTableHeaderCell scope="col">제목</CTableHeaderCell>
//             <CTableHeaderCell scope="col">작성시간</CTableHeaderCell>

//           </CTableRow>
//         </CTableHead>
//         <CTableBody>
//           <CTableRow>
//             <CTableDataCell>Mark</CTableDataCell>
//             <CTableDataCell>Mark</CTableDataCell>
//             <CTableDataCell>Mark</CTableDataCell>
//           </CTableRow>
//           <CTableRow>
//             <CTableDataCell>Jacob</CTableDataCell>
//             <CTableDataCell>Jacob</CTableDataCell>
//             <CTableDataCell>Jacob</CTableDataCell>
//           </CTableRow>
//           <CTableRow>
//             <CTableDataCell>@twitter</CTableDataCell>
//             <CTableDataCell>@twitter</CTableDataCell>
//               <CTableDataCell>@twitter</CTableDataCell>
//           </CTableRow>
//       </CTableBody>
//     </CTable>
//       </CCol>
//       <CCol sm={6}>
//       </CCol>
//     </CRow>
  )
}

WidgetsBrand.propTypes = {
  className: PropTypes.string,
  withCharts: PropTypes.bool,
}

export default WidgetsBrand
