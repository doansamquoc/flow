import { Link } from "@tanstack/react-router";
import { Shapes } from "lucide-react";
const Header = () => {
  return (
    <div className=''>
      <nav className='p-2 flex gap-2'>
        <Link to='/dashboard'>
          <Shapes />
        </Link>
        <Link to='/'>Overview</Link>
      </nav>
    </div>
  );
};

export default Header;
