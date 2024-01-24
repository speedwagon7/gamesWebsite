import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import './LoginPage.css';
import { useState } from 'react';
import { createUser, loginUser } from '../Services/UserService';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';

function LoginPage(){

    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleRegister = async(e) => {

        e.preventDefault()
        const user = {email, username, password}
        console.log(user)

        try {
            createUser(user).then((response) => {
                console.log(response.data)
            })
        } catch (error) {
            console.error('Error registering:', error);
        }
    }
    const handleLogin = async(e) => {
        
        e.preventDefault()
        const user = {email, username, password}
        console.log(user)

        try {
            loginUser(user).then((response) => {
                console.log(response.data)
            })
        } catch (error) {
            console.error('Error logging in:', error);
        }
    }
    return(
        <div className='LoginBox'>
            <Tabs
                id="uncontrolled-tab-example"
                defaultActiveKey={"login"}
                className="mb-3"
            >
                <Tab eventKey="login" title="login">
                    <div className='login'>
                            <Form onSubmit={handleLogin}>
                                <Form.Group className="mb-3" controlId="formBasicEmail">
                                    <Form.Label> Email Address </Form.Label>
                                        <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e) => setEmail(e.target.value)} />
                                </Form.Group>
                                <Form.Group className="mb-3" controlId="formBasicUsername">
                                    <Form.Label> Username </Form.Label>
                                        <Form.Control type="text" placeholder="Enter username" value={username} onChange={(e) => setUsername(e.target.value)} />
                                </Form.Group>
                                <Form.Group className="mb-3" controlId="formBasicPassword">
                                    <Form.Label> Password </Form.Label>
                                        <Form.Control type="password" placeholder="Enter Password" value={password} onChange={(e) => setPassword(e.target.value)}/>
                                </Form.Group>

                                <Form.Group className="mb-3">
                                    <Button variant="primary" type="submit">
                                        Login
                                    </Button>
                                </Form.Group>
                            </Form>
                        </div>
                </Tab>
                <Tab eventKey="register" title="register">
                    <div className='register'>
                        <Form onSubmit={handleRegister}>
                            <Form.Group className="mb-3" controlId="formBasicEmail">
                                <Form.Label> Email Address </Form.Label>
                                    <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e) => setEmail(e.target.value)} />
                                    <Form.Text className="text-muted">
                                        We'll never share your email with anyone else.
                                    </Form.Text>
                            </Form.Group>
                            <Form.Group className="mb-3" controlId="formBasicUsername">
                                <Form.Label> Username </Form.Label>
                                    <Form.Control type="text" placeholder="Enter username" value={username} onChange={(e) => setUsername(e.target.value)} />
                            </Form.Group>
                            <Form.Group className="mb-3" controlId="formBasicPassword">
                                <Form.Label> Password </Form.Label>
                                    <Form.Control type="password" placeholder="Enter Password" value={password} onChange={(e) => setPassword(e.target.value)}/>
                            </Form.Group>

                            <Form.Group className="mb-3">
                                <Button variant="primary" type="submit">
                                    Submit
                                </Button>
                            </Form.Group>
                        </Form>
                    </div>
                </Tab>
            </Tabs>
        </div>
    )
}
export default LoginPage;

