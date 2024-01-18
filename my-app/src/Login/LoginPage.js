import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import './LoginPage.css';


function LoginPage(){
    return(
        <div>
            <div className='LoginBox'>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label> Email Address </Form.Label>
                            <Form.Control type="email" placeholder="Enter email"/>
                            <Form.Text className="text-muted">
                                We'll never share your email with anyone else.
                            </Form.Text>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label> Password </Form.Label>
                            <Form.Control type="password" placeholder="Enter Password"/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicCheckbox">
                        <Form.Check type="checkbox" label="Check me out" />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form.Group>
                </Form>
            </div>
        </div>


    )
}
export default LoginPage;