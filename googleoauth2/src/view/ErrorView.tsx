interface Properties {
    Error: string;
    /*key: ConstrainULong;*/
}

function errorView({Error}: Properties) {


    return (
        <div>
            <h1>An Error Occurred</h1>
            <p>{Error}</p>
        </div>
        
        
        );
}

export default errorView;