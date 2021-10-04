import './App.css';
import {AppRoutes} from "./AppRoutes";
import MainApp from "./components/MainApp";

function App() {
    return (
        <div className="App">
            <header className="App-header">
            </header>
            <MainApp>
                <AppRoutes/>
            </MainApp>
        </div>
    );
}

export default App;
