import React, {FC} from 'react';

const MainApp: FC = ({children}) => {
    return (
        <>
            <div className="App">{children}</div>
        </>
    );
};
export default MainApp;