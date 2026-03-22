import { Aionlabs } from "@thesvg/react";

interface LogoProps {
  size?: "24";
}

const Logo = ({ size = "24" }: LogoProps) => {
  return <Aionlabs className='size-8' />;
};

export default Logo;
