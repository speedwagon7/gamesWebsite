import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import './LoginPage.css';
import axios from 'axios';
import { useState } from 'react';

function LoginPage(){

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleClick = async() => {
        try {
            const response = await axios.post("http://localhost:8080/api/users/register")
        } catch (error) {
            console.error('Error submitting form:', error);
        }
        

    }
    return(
        <div>
            <div className='LoginBox'>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label> Email Address </Form.Label>
                            <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e) => setEmail(e.target.value)} />
                            <Form.Text className="text-muted">
                                We'll never share your email with anyone else.
                            </Form.Text>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label> Password </Form.Label>
                            <Form.Control type="password" placeholder="Enter Password" value={password} onChange={(e) => setPassword(e.target.value)}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicCheckbox">
                        <Form.Check type="checkbox" label="Check me out" />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Button onClick={handleClick} variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form.Group>
                </Form>
            </div>
        </div>


    )
}
export default LoginPage;