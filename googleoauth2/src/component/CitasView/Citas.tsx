import { useEffect, useMemo } from "react";
import { useSelector } from "react-redux";
import Tabla from '../Tabla';
import cita from "../../model/Cita";
import { selectCitas } from "../CitaState/CitaSlice";
import NavBar from "../NavBar/NavBar";
import { Link, NavLink } from "react-router-dom";
import SideNav from '../SideBar/SideBar';
import './Citas.css';
import CitaPanel from '../CitaPanel/CitaPanel';

function Citas() {

  /*  useEffect(() => {
        if()
    }, [] )*/
    const data: cita[] = useSelector(selectCitas);
    /*
    const Styles = styled.div`
    padding: 1rem;
    
   
    table th{
        background-color:#7DA2A9;
        height: 40px;
        font-size:2.5rem;
    }

    table td {
        font-size:1.6rem;
        background-color:#F7F7F7;
    }
    
    table {
     border-spacing: 0;
     border: 1px solid black;
     width: 800px;
     height: 200px;
    
     tr {
       :last-child {
         td {
           border-bottom: 0;
           
         }
       }
     }


    
     th ,
     td {
       margin: 0;
       padding: 0.5rem;
       border-bottom: 1px solid black;
       border-right: 1px solid black;
       align-items:center;
       text-align:center;

         :last-child {
         border-right: 0;
        }
      }
    } 
`
*/
    const columns = useMemo(() => [
        {
            Header: 'Cita',
            columns: [
                {
                    Header: 'Fecha',
                    accessor: 'fechaHora',
                    Cell: ({ row }) => <p>{row.original.fechaHora  }</p>,
                },
                {
                    Header: 'Motivo',
                    accessor: 'motivoCita',
                },
            ],
        },
        {
            Header: 'Diagnostico',
            columns: [
                {
                    Header: 'Enfermedad',
                    accessor: 'diagnostico.enfermedad',
                    Cell: ({ row }) => <NavLink className="active" to="/noExiste" >{row.original.diagnostico.enfermedad}</NavLink>,
                },
                {
                    Header: 'Valoracion',
                    accessor: 'diagnostico.valoracionEspecialista',
                },
            ],
        },
        {
            Header: 'Medico',

            columns: [
                {
                    Header: 'Nombre',
                    accessor: 'medico.nombre',
                    Cell: ({ row }) => <NavLink className="active" to="/noExiste" >{row.original.medico.nombre+ " "+row.original.medico.apellidos}</NavLink>,
                },
                {
                    Header: 'Colegio',
                    accessor: 'medico.numColegio',
                    Cell: ({ row }) => <NavLink className="active" to="/noExiste" >{row.original.medico.numColegio}</NavLink>,
                },
               
            ],
        },

        ]
    , []);

    const imprime = () => {
        console.log(data);
    }
    return (
        <div className="CitasView-Container">
            <SideNav />
            <div className="CitasPanel">
                {data.map((cita) => <CitaPanel key={String(cita.citaId)} cita={cita} />)}
            </div>
        </div>
        
        );
}


export default Citas;


